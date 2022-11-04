package com.sangeng.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @TableId
    private Long id;


    @Override
    public int hashCode() {
        return id.hashCode();
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseEntity) {
            BaseEntity base = (BaseEntity) obj;
            return base.getId().equals(this.id);
        } else {
            return false;
        }
    }
}
