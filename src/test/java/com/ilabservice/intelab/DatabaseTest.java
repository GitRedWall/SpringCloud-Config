package com.ilabservice.intelab;

import com.ilabservice.intelab.model.*;
import com.ilabservice.intelab.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by zyclincoln on 8/10/17.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:intelab_mysql_bootstrap_v2.0.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:intelab_mysql_bootstrap_v2.0_init_value.sql") })
public class DatabaseTest {

//    @Configuration
//    @EnableAutoConfiguration
//    public static class Config {}

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    GeoLocationRepository geoLocationRepository;

    @Autowired
    CommonLookupRepository commonLookupRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    EventActionRepository eventActionRepository;

    @Autowired
    EventConditionRepository eventConditionRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventRuleConditionMapRepository eventRuleConditionMapRepository;

    @Autowired
    EventRuleRepository eventRuleRepository;

    @Autowired
    IoTDeviceRepository ioTDeviceRepository;

    @Autowired
    MeasureTypeRepository measureTypeRepository;

    @Autowired
    MonTargetRepository monTargetRepository;

    @Autowired
    MonTargetTypeRepository monTargetTypeRepository;

    @Autowired
    RentClauseRepository rentClauseRepository;

    @Autowired
    Pt100Repository pt100Repository;

    @Autowired
    MonTargetTypeDefaultRuleRepository monTargetTypeDefaultRuleRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    MonTargetGroupRepository monTargetGroupRepository;

    @Autowired
    MonTargetDisableSharingStrategyRepository monTargetDisableSharingStrategyRepository;

    @Autowired
    CameraListRepository cameraListRepository;

    @Autowired
    BlockChainDealRecordRepository blockChainDealRecordRepository;

    @Test
    public void BlockChainDealRecordTest(){
        MonTarget monTarget = monTargetRepository.findOne(1L);
        User lessor = userRepository.findOne(1L);
        User lessee = userRepository.findOne(2L);
        BlockChainDealRecord blockChainDealRecord = new BlockChainDealRecord(monTarget, lessor, lessee, 60.0, new Date(new Date().getTime()-60000), new Date(), "arguement", 6);
        blockChainDealRecordRepository.save(blockChainDealRecord);
        BlockChainDealRecord blockChainDealRecord1 = blockChainDealRecordRepository.findOne(1L);
        assertEquals("administrator@ILAB", blockChainDealRecord1.getLessor().getUserName());
    }

    @Test
    public void CameraListTest(){
        MonTarget monTarget = monTargetRepository.findOne(1L);
        CameraList cameraList = new CameraList("nameTest", monTarget, "serialNoTest", "playURLTest", "description");
        cameraListRepository.save(cameraList);
        CameraList cameraList1 = cameraListRepository.findOne(1L);
        assertEquals("nameTest", cameraList1.getName());
    }

    @Test
    public void DeviceTest(){
        Device device = new Device("codeTest", "nameTest", new Date(), "photoURL", "manufacturerTest", "modelTest", 76.5f, new Date());
        deviceRepository.save(device);
        Device device1 = deviceRepository.findOne(1L);
        assertEquals("codeTest", device1.getCode());
    }

    @Test
    public void testMonTarType(){
        MonTargetType monTargetType = monTargetTypeRepository.findOne(1L);
        MeasureType measureType = measureTypeRepository.findOne(47L);
        MonTargetTypeDefaultRule monTargetTypeDefaultRule1 = new MonTargetTypeDefaultRule(monTargetType, measureType, null, null, null, null, null, new Date());
        monTargetTypeDefaultRuleRepository.save(monTargetTypeDefaultRule1);
        MonTargetTypeDefaultRule monTargetTypeDefaultRule = monTargetTypeDefaultRuleRepository.findByMonTargetTypeIdAndMeasureTypeId((long)1, (long)47);
        assertEquals("decibel", monTargetTypeDefaultRule.getMeasureType().getMeasurement());
    }

    @Test
    public void MonTargetDisableSharingStrategyTest(){
        MonTarget monTarget = monTargetRepository.findOne(1L);
        MonTargetDisableSharingStrategy monTargetDisableSharingStrategy = new MonTargetDisableSharingStrategy(monTarget, "yearly", "1505701068000,1505960268000");
        monTargetDisableSharingStrategyRepository.save(monTargetDisableSharingStrategy);
        List<MonTargetDisableSharingStrategy> monTargetDisableSharingStrategies = monTargetDisableSharingStrategyRepository.findByMonTargetId(1L);
        assertEquals("1505701068000,1505960268000", monTargetDisableSharingStrategies.get(0).getContent());
    }

    @Test
    public void pt100Test(){
        Pt100 pt1001 = new Pt100("-200", 18.52);
        Pt100 pt1002 = new Pt100("-190", 22.83);
        Pt100 pt1003 = new Pt100("-180", 27.1);
        List<Pt100> pt100List = new ArrayList<>();
        pt100List.add(pt1001);
        pt100List.add(pt1002);
        pt100List.add(pt1003);
        pt100Repository.save(pt100List);

        List<Pt100> pt100s = pt100Repository.findByResistanceGreaterThanOrderByResistanceAsc(18.52);
        assertEquals("-190", pt100s.get(0).getTemperature());
    }

    @Test
    public void testRole(){
        List<Role> roles = roleRepository.findAll();
        assertEquals("ADMINSTRATOR", roles.get(0).getName());
    }

    @Test
    public void GeoLocationTest(){
        GeoLocation floor4 = geoLocationRepository.findByName("4th Floor");
        GeoLocation newFloor = new GeoLocation(floor4, "testFloor", "testFloor", "test address",
                "air space", "GMT", "100", "100", new Date(), 10.0f,
                10.2f, 0, 1);
        geoLocationRepository.save(newFloor);
        assertEquals(3, floor4.getChildLocation().size());
    }

    @Test
    public void UserTest(){
        assertNotNull(userRepository.findOne(1L));
        Company firstCompany = companyRepository.findOne(1L);
        User newUser = new User(firstCompany, "testUser", "testUser", "testUser", null,
                null, null, null, null, null, null, null,
                0, 0, 0, new Date(), new Date());
        newUser.addRole(roleRepository.findByName("ADMINSTRATOR"));
        newUser.addRole(roleRepository.findByName("DEFAULT"));
        userRepository.save(newUser);
        assertEquals(2, roleRepository.findByName("ADMINSTRATOR").getUsers().size());
    }

    @Test
    public void testSort(){
        List<User> users = userRepository.findByAndSort((long)1, new Sort(Sort.Direction.DESC, "id"));
        for (Role role : users.get(1).getRoles()){
            assertEquals("ADMINSTRATOR", role.getName());
        }
    }

    @Test
    public void testPage(){
        Page<User> users = userRepository.findByCompanyId((long) 1, new Pageable() {
            @Override
            public int getPageNumber() {
                return 1;
            }

            @Override
            public int getPageSize() {
                return 10;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return new Sort(Sort.Direction.DESC, "id");
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });

        assertEquals(2, users.getTotalElements());
    }

    @Test
    public void CommonLookupTest(){
        assertNotNull(commonLookupRepository.findOne(1L));
        CommonLookup commonLookup = new CommonLookup("categoryNameTest", "categoryDescTest", "codeTest", "valueTest", 2, new Date());
        commonLookupRepository.save(commonLookup);
        CommonLookup commonLookup1 = commonLookupRepository.findOne(14L);
        assertEquals("categoryNameTest", commonLookup1.getCategoryName());
    }

    @Test
    public void CompanyTest(){
        assertNotNull(companyRepository.findOne(1L));
        Company company = new Company("sysCodeTest", "nameTest", "addressTest", null, null, "contractNo", new Date(), new Date(), "loginUrlTest", null,
                "logoTest", null, null, null);
        companyRepository.save(company);
        Company company1 = companyRepository.findOne(2L);
        assertEquals("sysCodeTest", company1.getSysCode());
    }

    @Test
    public void EventActionTest(){
        assertNotNull(eventActionRepository.findOne(1L));
        EventRule eventRule = eventRuleRepository.findOne(2L);
        Set<EventRule> eventRules = new HashSet<>();
        eventRules.add(eventRule);
        EventAction eventAction = new EventAction("MSN", "Send MSN ", 1, eventRules);
        eventActionRepository.save(eventAction);
        EventAction eventAction1 = eventActionRepository.findOne(3L);
        assertEquals("MSN", eventAction1.getActionName());
    }

    @Test
    public void EventConditionTest(){
        assertNotNull(eventConditionRepository.findOne(1L));
        MeasureType measureType = measureTypeRepository.findByCode("2e");
        IoTDevice ioTDevice = ioTDeviceRepository.findOne(2L);
        EventCondition eventCondition = new EventCondition(measureType, ioTDevice, "==", 50f, new Date());
        eventConditionRepository.save(eventCondition);
        List<EventCondition> eventConditions = eventConditionRepository.findAll();
        assertEquals(3, eventConditions.size());
    }

    @Test
    public void EventTest(){
        assertNotNull(eventRepository.findOne(1L));
        IoTDevice ioTDevice = ioTDeviceRepository.findOne(1L);
        EventRule eventRule = eventRuleRepository.findOne(2L);
        Event event = new Event(ioTDevice, eventRule, 1, new Date(), new Date(), null, null, null, new Date());
        eventRepository.save(event);
        List<Event> events = eventRepository.findAll();
        assertEquals(1, events.get(2).getCounts().intValue());
    }

    @Test
    public void EventRuleConditionMapTest(){
        assertNotNull(eventRuleConditionMapRepository.findOne(1L));
        EventRule eventRule = eventRuleRepository.findOne(2L);
        EventCondition eventCondition = eventConditionRepository.findOne(2L);
        EventRuleConditionMap eventRuleConditionMap = new EventRuleConditionMap(eventRule, eventCondition, 1, "AND", new Date());
        eventRuleConditionMapRepository.save(eventRuleConditionMap);
        EventRuleConditionMap eventRuleConditionMap1 = eventRuleConditionMapRepository.findAll().get(2);
        assertEquals("AND",eventRuleConditionMap1.getOperator());
    }

    @Test
    public void EventRuleTest(){
        assertNotNull(eventRuleRepository.findOne(1L));
        MonTargetType monTargetType = monTargetTypeRepository.findOne(2L);
        EventRule eventRule = new EventRule("test", "testDescription", new Date(), monTargetType, null);
        eventRuleRepository.save(eventRule);
        List<EventRule> eventRules = (List<EventRule>)eventRuleRepository.findAll();
        assertEquals(3, eventRules.size());
    }

    @Test
    public void IoTDeviceTest(){
        assertNotNull(ioTDeviceRepository.findOne(1L));
        IoTDevice ioTDevice = new IoTDevice("Simulator_3", 100.0f, 1, "SIMULATOR", null, new Date());
        ioTDeviceRepository.save(ioTDevice);
        List<IoTDevice> ioTDevices = (List<IoTDevice>)ioTDeviceRepository.findAll();
        assertEquals(3, ioTDevices.size());
    }

    @Test
    public void PermissionTest(){
        assertNotNull(permissionRepository.findOne(1L));
        Permission permission = permissionRepository.findOne(14L);
        Role role = new Role("rest", null, null, new Date());
        Set<Role> roleSet = permission.getRolesWithPermission();
        roleSet.add(role);
        permission.setRolesWithPermission(roleSet);
        permission = permissionRepository.save(permission);
        assertEquals(3, permission.getRolesWithPermission().size());
    }

    @Test
    public void RentClauseTest() {
        RentClause rentClause = new RentClause(1L, "预约生效自动扣除金额");
        RentClause rentClause1 = rentClauseRepository.save(rentClause);
        assertEquals("预约生效自动扣除金额", rentClause1.getContent());
    }

    @Test
    public void RoleTest(){
        assertNotNull(roleRepository.findOne(1L));
        Role role = roleRepository.findOne(1L);
        Company company = companyRepository.findOne(1L);
        Set<User> users = role.getUsers();
        User user = new User(company, "test", "test123", null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        users.add(user);
        role.setUsers(users);
        role = roleRepository.save(role);
        assertEquals(2, role.getUsers().size());
    }

    @Test
    public void MeasureTypeTest(){
        assertNotNull(measureTypeRepository.findOne(47L));
        MeasureType measureType = measureTypeRepository.findByCode("2e");
        assertEquals("decibel",measureType.getMeasurement());
    }

    @Test
    public void MonTargetGroupTest(){
        List<MonTarget> monTargets = (List<MonTarget>) monTargetRepository.findAll();
        Set<MonTarget> monTargetSet = new HashSet<>();
        for (MonTarget monTarget : monTargets){
            monTargetSet.add(monTarget);
        }
        MonTargetGroup monTargetGroup = new MonTargetGroup("testGroup", "ASC", 1, "testRule", null, new Date(), monTargetSet);
        monTargetGroupRepository.save(monTargetGroup);
        assertNotNull(monTargetGroupRepository.findOne(1L));
    }

    @Test
    public void MonTargetTest(){
        assertNotNull(monTargetRepository.findOne(1L));
        MonTarget monTarget = monTargetRepository.findOne(1L);
        User user = userRepository.findOne(1L);
        monTarget.setOwner(user);
        monTarget.setBlockChainKey("block_chain_key");
        monTarget.setRent_clause("rent_clause");
        monTarget.setRentPricePerHour(60.0);
        monTarget.setLatestRunningStatus(20);
        monTargetRepository.save(monTarget);
        monTarget = monTargetRepository.findOne(1L);
        assertEquals(20, monTarget.getLatestRunningStatus().intValue());
    }

    @Test
    public void MonTargetTypeTest(){
        assertNotNull(monTargetTypeRepository.findOne(1L));
        MonTargetType monTargetType = new MonTargetType("demoTest", null, null, new Date(), null);
        monTargetTypeRepository.save(monTargetType);
        List<MonTargetType> monTargetTypes = monTargetTypeRepository.findAllByOrderByCreateDateTimeDesc();
        assertEquals(3, monTargetTypes.size());
    }

    @Test
    public void SensorTest() {
        assertNotNull(sensorRepository.findOne(1L));
        IoTDevice ioTDevice = ioTDeviceRepository.findOne(1L);
        Sensor sensor = new Sensor("Sensor_Power", ioTDevice, null, null, null, null, null, null, null, null,null, new Date());
        sensorRepository.save(sensor);
        List<Sensor> sensors = sensorRepository.findByDeviceId(1L);
        assertEquals(3, sensors.size());
    }
}
