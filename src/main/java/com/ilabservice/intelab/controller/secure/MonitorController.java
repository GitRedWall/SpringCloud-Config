package com.ilabservice.intelab.controller.secure;

import com.ilabservice.intelab.model.*;
import com.ilabservice.intelab.repository.*;
import com.ilabservice.intelab.restful.object.RestMeasureType;
import com.ilabservice.intelab.restful.object.RestMonitorTarget;
import com.ilabservice.intelab.restful.object.RestMonitorTargetType;
import com.ilabservice.intelab.restful.object.RestObject;
import com.ilabservice.intelab.restful.request.MeasureTypeRequest;
import com.ilabservice.intelab.restful.request.MonitorTargetTypeRequest;
import com.ilabservice.intelab.security.auth.JwtAuthenticationToken;
import com.ilabservice.intelab.security.model.UserContext;
import com.ilabservice.intelab.service.AuthorityCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController("secureMonitorController")
@RequestMapping(value="/api/secure/customer/")
public class MonitorController {

    private static Logger logger = LoggerFactory.getLogger(MonitorController.class);

    @Autowired
    MeasureTypeRepository measureTypeRepository;

    @Autowired
    MonTargetTypeRepository monTargetTypeRepository;

    @Autowired
    ResourceRoleUserMapRepository resourceRoleUserMapRepository;

    @Autowired
    MonTargetRepository monTargetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityCheck authorityCheck;

    @RequestMapping(value="/measure_type", method = RequestMethod.GET)
    public @ResponseBody
    Object GetMeasureTypeDetailInfo(@RequestParam("id") long measure_type_id){
        MeasureType measureType = measureTypeRepository.findOne(measure_type_id);
        if(measureType == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestObject(null, "invalid id", 404));
        }
        else{
            return new RestObject(new RestMeasureType(measureType));
        }
    }

    @RequestMapping(value="/measure_type/create", method = RequestMethod.POST)
    public @ResponseBody
    Object CreateMeasureType(JwtAuthenticationToken token, @Valid @RequestBody MeasureTypeRequest measureTypeRequest){

        if(authorityCheck.checkPermissionsWithUserId(((UserContext)token.getPrincipal()).getId(), AuthorityCheck.measureTypeCreatePermissions)){
            MeasureType measureType = new MeasureType(measureTypeRequest.getName(),
                    measureTypeRequest.getCode(),
                    measureTypeRequest.getUnit(),
                    measureTypeRequest.getMeasurement());
            try {
                measureTypeRepository.save(measureType);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestObject(null, "server error: "+ e.getMessage(), 500));
            }
            return new RestObject(new RestMeasureType(measureType));
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new RestObject(null, "no enough permission", 401));
        }
    }


    @RequestMapping(value="/monitor_target_type", method = RequestMethod.GET)
    public @ResponseBody
    Object GetMonitorTargetTypeDetailInfo(@RequestParam("id") long monitor_target_type_id){
        MonTargetType monTargetType = monTargetTypeRepository.findOne(monitor_target_type_id);
        if(monTargetType == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestObject(null, "invalid id", 404));
        }
        else{
            return new RestObject(new RestMonitorTargetType(monTargetType));
        }
    }

    @RequestMapping(value="/monitor_target_type/create", method = RequestMethod.POST)
    public @ResponseBody
    Object CreateMeasureType(JwtAuthenticationToken token, @Valid @RequestBody MonitorTargetTypeRequest monitorTargetTypeRequest){
        //todo: implement
        return null;
    }

    @RequestMapping(value="/monitor_target", method = RequestMethod.GET)
    public @ResponseBody
    Object GetMonitorTargetDetailInfo(JwtAuthenticationToken token, @RequestParam("id") long monitor_target_id){

        MonTarget monTarget = monTargetRepository.findOne(monitor_target_id);

        if(monTarget == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestObject(null, "invalid id", 404));
        }

        if(authorityCheck.checkPermissionsWithUserId(((UserContext)token.getPrincipal()).getId(), AuthorityCheck.monTargetReaPermissionValue)){
            return new RestObject(new RestMonitorTarget(monTarget));
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new RestObject(null, "no enough permission", 401));
        }
    }

}
