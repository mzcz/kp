package com.kp.spring.repository;

import com.kp.spring.domain.Approver;
import com.kp.spring.domain.ApproverType;
import com.kp.spring.domain.KpUser;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApproverDaoTestSuite {

    @Autowired
    private ApproverDao approverDao;
    @Autowired
    private UserRepository userDao;

    private static final String DESCRIPTION = "test approval";

    @Test
    public void testApproverDaoSave(){

        //Given
        Approver approver = new Approver("DESCRIPTION");
        Approver approver2 = new Approver("DESCRIPTION2");

        ApproverType approverType = new ApproverType("skarbnik");

        approver.setApproverType(approverType);
        approver2.setApproverType(approverType);

        KpUser kpUser = new KpUser("mz","test","tester");

        kpUser.getApprovers().add(approver);
        kpUser.getApprovers().add(approver2);

        approver.setLogin(kpUser);
        approver2.setLogin(kpUser);
        //When
        userDao.save(kpUser);


        //Then
        //long id = approver.getId();
        long id = kpUser.getId();

        //Assert.assertEquals(id, readApprover.getId());
        Assert.assertNotEquals(0, id);

        //Cleanup
        userDao.deleteById(id);

    }
    @Ignore
    @Test
    public void testNamedQueries() {
        //Given

        //When
        List<KpUser> retrieveMarcin = userDao.retrieveMarcin();
        List<KpUser> retrieveId = userDao.retrieveId(1);
        List<KpUser> retrieveSurname = userDao.retrieveSurname();

        //Then
        try {
            Assert.assertEquals(2, retrieveMarcin.size());
            Assert.assertEquals(3, retrieveId.size());
            Assert.assertEquals(1, retrieveSurname.size());
        } finally {
            //CleanUp
           // taskListDao.delete(id);
        }
    }
}
