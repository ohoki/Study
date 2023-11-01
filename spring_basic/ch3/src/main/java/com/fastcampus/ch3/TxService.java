package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

//@Transaction이 동작하지 않는 이유는 같은 클래스에 속한 메서드끼리의 호출(내부 호출)이기 때문
//프록시 방식(디폴트)의 AOP는 내부 호출인 경우, Advice가 적용되지 않음 그래서 Tx가 적용되지 않음
@Service
public class TxService {
    @Autowired A1Dao a1Dao;
    @Autowired B1Dao b1Dao;
    @Autowired DataSource ds;

    //@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertA1WithTx() throws Exception{
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
        txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = tm.getTransaction(txd);

        try {
            a1Dao.insert(1, 100); // 성공
            insertB1WithTx();
            a1Dao.insert(2, 100); // 성공
            tm.commit(status);
        } catch (Exception e) {
            tm.rollback(status);
            e.printStackTrace();
        } finally {
        }
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertB1WithTx() throws Exception{
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
        txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = tm.getTransaction(txd);

        try {
            b1Dao.insert(1, 100); //성공
            b1Dao.insert(1, 200); //실패
            tm.commit(status);
        } catch (Exception e) {
            tm.rollback(status);
            e.printStackTrace();
        } finally {
        }
    }

    public void insertA1WithoutTx() throws Exception{
        a1Dao.insert(1, 100);
        a1Dao.insert(1, 200);
    }
    
    //@Transactional - RuntimeException, Error만 rollback 함
    @Transactional(rollbackFor = Exception.class) //Exception을 rollback 함
    public void insertA1WithTxFail() throws Exception{
        a1Dao.insert(1, 100);
        a1Dao.insert(1, 200);
    }

    @Transactional
    public void insertA1WithTxSuccess() throws Exception{
        a1Dao.insert(1, 100);
        a1Dao.insert(2, 200);
    }
}
