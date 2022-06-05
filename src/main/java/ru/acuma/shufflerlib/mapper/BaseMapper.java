package ru.acuma.shufflerlib.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ru.acuma.shufflerlib.mapper.converters.DateTimeConverter;

public class BaseMapper {

    protected final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    {
        mapperFactory.getConverterFactory().registerConverter(new DateTimeConverter());
    }

}
