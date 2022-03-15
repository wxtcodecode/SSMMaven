package com.wxtwxt.service.serviceImpl;

import com.wxtwxt.mapper.EmpMapper;
import com.wxtwxt.pojo.Emp;
import com.wxtwxt.pojo.EmpExample;
import com.wxtwxt.service.LoginService;
import com.wxtwxt.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wxt
 * @create 2022-03-14 19:05
 */
@Service
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public Emp selectEmpByLoginAccount(String loginAccount, String loginPassword) {
        String encode = MD5Util.encode(loginPassword);
        EmpExample example = new EmpExample();
        example.createCriteria().andLoginAccountEqualTo(loginAccount).andLoginPasswordEqualTo(encode);
        List<Emp> emps = empMapper.selectByExample(example);
        if(emps != null && emps.size() > 0) {
            return emps.get(0);
        }else {
            return null;
        }
    }
}
