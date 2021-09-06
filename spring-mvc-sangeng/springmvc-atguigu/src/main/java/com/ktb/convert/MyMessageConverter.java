package com.ktb.convert;

import com.ktb.model.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

//https://www.cnblogs.com/hhhshct/p/9676604.html
public class MyMessageConverter extends AbstractHttpMessageConverter<User> {

    public MyMessageConverter() {
        // 新建一个我们自定义的媒体类型application/xxx-junlin
        super(new MediaType("application", "xxx-junlin", Charset.forName("UTF-8")));
    }

    // 表明只处理UserEntity类型的参数。
    @Override
    protected boolean supports(Class<?> aClass) {

        return User.class.isAssignableFrom(aClass);
    }

    /**
     * 重写readlntenal 方法，处理请求的数据。代码表明我们处理由“-”隔开的数据，并转成 UserEntity类型的对象。
     * 要让程序进入这个方法 Content-Type= application/xxx-junlin
     */
    @Override
    protected User readInternal(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new User(tempArr[0],tempArr[1]);
    }

    /**
     * 重写writeInternal ，处理如何输出数据到response。
     * 要让程序进入这个方法 Accept = application/xxx-junlin
     */
    @Override
    protected void writeInternal(User userEntity, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
////        final Workbook workbook = new HSSFWorkbook();
////        final Sheet sheet = workbook.createSheet();
////
////        final Row row = sheet.createRow(0);
////        row.createCell(0).setCellValue(userEntity.getName());
////        row.createCell(1).setCellValue(userEntity.getAddress());
//
//        workbook.write(httpOutputMessage.getBody());

        String out = "hello: " + userEntity.getUsername() + "-" + userEntity.getPassword();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
