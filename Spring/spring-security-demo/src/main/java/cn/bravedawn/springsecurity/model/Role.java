package cn.bravedawn.springsecurity.model;

import cn.bravedawn.springsecurity.constant.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private RoleType roleType;

}
