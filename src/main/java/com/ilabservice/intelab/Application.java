package com.ilabservice.intelab;

import com.ilabservice.intelab.rest.HomeController;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.retry.annotation.EnableRetry;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zyclincoln on 8/10/17.
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableRetry
public class Application {

    public static void main(String[] args) throws Throwable {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                HomeController one = context.getBean(HomeController.class);
                System.out.println( one + " -> started: " + one.started.get() + " ended:" + one.ended.get() );
            }
        }));
    }


    /**
     * 用于接受shutdown事件
     * @return
     */
    @Bean
    public GracefulShutdown gracefulShutdown() {
        return new GracefulShutdown();
    }

    /**
     * 用于注入 connector
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer tomcatCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof TomcatEmbeddedServletContainerFactory) {
                    ((TomcatEmbeddedServletContainerFactory) container).addConnectorCustomizers(gracefulShutdown());
                }
            }
        };

    }

    /**
     * 优雅退出的关键是要拿到内置的tomcat连接
     *
     * */
    @Slf4j
    private static class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

        private volatile Connector connector;
        private final int waitTime = 100;

        @Override
        public void customize(Connector connector) {
            this.connector = connector;
        }

        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            this.connector.pause();
            Executor executor = this.connector.getProtocolHandler().getExecutor();
            if (executor instanceof ThreadPoolExecutor) {
                try {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                    threadPoolExecutor.shutdown();
                    if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
                        log.warn("Tomcat thread pool did not shut down gracefully within "
                                + waitTime + " seconds. Proceeding with forceful shutdown");
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }




}