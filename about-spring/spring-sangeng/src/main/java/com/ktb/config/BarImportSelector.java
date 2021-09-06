package com.ktb.config;

import com.ktb.model.Bar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class BarImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[]{Bar.class.getName()};
        return new String[]{};
    }
}
