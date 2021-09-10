package com.ktb.juejin.importexample.config;

import com.ktb.juejin.importexample.model.Bar;
import com.ktb.model.Boss;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class BarImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Boss.class.getName()};
//        return new String[]{};
    }

}
