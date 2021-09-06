package com.ktb.model;

import com.ktb.config.BarImportSelector;
import com.ktb.config.BartenderConfiguration;
import com.ktb.config.WaiterRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class, BartenderConfiguration.class, BarImportSelector.class, WaiterRegistrar.class})
public @interface EnableTavern {

}
