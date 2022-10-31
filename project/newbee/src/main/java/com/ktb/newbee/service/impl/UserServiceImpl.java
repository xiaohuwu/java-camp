package com.ktb.newbee.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.newbee.config.Result;
import com.ktb.newbee.dao.TokenDao;
import com.ktb.newbee.dao.UserDao;
import com.ktb.newbee.entity.Token;
import com.ktb.newbee.entity.User;
import com.ktb.newbee.entity.param.LoginParam;
import com.ktb.newbee.entity.vo.UserVo;
import com.ktb.newbee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * (TbNewbeeMallUser)表服务实现类
 *
 * @author makejava
 * @since 2022-10-31 14:30:33
 */
@Service("userService")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    TokenDao tokenDao;

    private String getNewToken(String timeStr, Long userId) {
        String src = timeStr + userId + RandomUtil.randomString(5);
        return src;
    }

    @Override
    public Result<Object> login(LoginParam param) {
        User user = userDao.selectOne(new QueryWrapper<User>().eq("login_name", param.getLoginName()).eq("password_md5", param.getPassword()));
        if (user == null) {
            return Result.error("用户名或密码错误");
        } else {
            QueryWrapper<Token> user_id = new QueryWrapper<Token>().eq("user_id", user.getUserId());
            Token token = tokenDao.selectOne(user_id);
            LocalDateTime nextTime = LocalDateTime.now().plusHours(12);
            log.info("token :{}", token);
            if (token == null) {
                token = new Token();
                token.setUserId(user.getUserId())
                        .setToken(getNewToken(System.currentTimeMillis() + "", user.getUserId()))
                        .setUpdateTime(LocalDateTime.now())
                        .setExpireTime(nextTime);
                tokenDao.insert(token);
            } else {
                token.setToken(getNewToken(System.currentTimeMillis() + "", user.getUserId()))
                        .setUpdateTime(LocalDateTime.now())
                        .setExpireTime(nextTime);
                UpdateWrapper<Token> updateWrapper = new UpdateWrapper<Token>().eq("user_id", user.getUserId());
                tokenDao.update(token, updateWrapper);
            }
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            userVo.setToken(token.getToken());
            return Result.ok(userVo);
        }
    }
}




