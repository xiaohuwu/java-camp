package com.ktb.mapper;

import com.ktb.model.Customer;
import com.ktb.model.CustomerRM;
import com.ktb.model.CustomerVo;
import com.ktb.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    public Long   save(CustomerVo customer);

    public Customer get(@Param("id") int id,@Param("name") String name);

    public Long update(Customer customer);

    public void testParameterType(CustomerVo c);

    public Long queryTotalCount();

    public CustomerRM queryCustomerResultMap(int i);


    public List<Customer> queryByNameAndTelephone(Customer customer);


    public List<Customer> queryByNameAndTelephone2(Customer customer);


    List<Customer> findByIds(@Param("ids") Integer[] ids);

}
