package com.github.tivonse.checkoutsystem.mod.sbo.controller.generic;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@RequestMapping(value = "/api/v1/sbo")
public abstract class EntityController<T extends Serializable> {
}
