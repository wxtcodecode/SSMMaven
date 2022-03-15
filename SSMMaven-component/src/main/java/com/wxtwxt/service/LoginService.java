package com.wxtwxt.service;

import com.wxtwxt.pojo.Emp;

/**
 * @author Wxt
 * @create 2022-03-14 19:04
 */
public interface LoginService {
    Emp selectEmpByLoginAccount(String loginAccount,String loginPassword);
}
