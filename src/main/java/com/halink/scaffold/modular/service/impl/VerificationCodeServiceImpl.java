package com.halink.scaffold.modular.service.impl;

import com.halink.scaffold.common.constant.ExceptionCodeConstants;
import com.halink.scaffold.common.constant.ExceptionMessageConstants;
import com.halink.scaffold.common.constant.SystemConstants;
import com.halink.scaffold.common.exception.VerificationCodeException;
import com.halink.scaffold.core.redis.RedisClient;
import com.halink.scaffold.core.util.VerificationCodeUtils;
import com.halink.scaffold.modular.service.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 验证码服务
 *
 * @author halink
 * @date 2020/9/29 4:00 下午
 */
@Service
@RequiredArgsConstructor
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private final RedisClient redisClient;

    /**
     * 生成图片验证码
     *
     * @param request  request
     * @param response response
     */
    @Override
    public void image(HttpServletRequest request, HttpServletResponse response) {
        String jSessionId = request.getSession().getId();
        VerificationCodeUtils instance = VerificationCodeUtils.getInstance();
        BufferedImage image = instance.getImage();
        redisClient.setex(jSessionId, SystemConstants.FIVE_MINUTES_SECONDS, instance.getText());
        try {
            ImageIO.write(image, "jpeg", response.getOutputStream());
        } catch (IOException e) {
            throw new VerificationCodeException(ExceptionCodeConstants.VERIFICATION_CODE_GENERATE_EXCEPTION, ExceptionMessageConstants.VERIFICATION_CODE_GENERATE_EXCEPTION);
        }
    }
}
