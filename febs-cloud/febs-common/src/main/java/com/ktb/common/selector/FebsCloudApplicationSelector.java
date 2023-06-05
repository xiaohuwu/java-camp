package com.ktb.common.selector;

import com.ktb.common.configure.FebsAuthExceptionConfigure;
import com.ktb.common.configure.FebsOAuth2FeignConfigure;
import com.ktb.common.configure.FebsServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class FebsCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                FebsAuthExceptionConfigure.class.getName(),
                FebsOAuth2FeignConfigure.class.getName(),
                FebsServerProtectConfigure.class.getName()
        };
    }
}
