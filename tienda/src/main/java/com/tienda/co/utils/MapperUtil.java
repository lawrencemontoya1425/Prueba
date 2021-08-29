package com.tienda.co.utils;

import org.modelmapper.ModelMapper;

public class MapperUtil {

	private static ModelMapper modelMapper = new ModelMapper();
	
	private MapperUtil() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static <S, T> T convertToDto(S source, Class<T> targetClass) {
		  return modelMapper.map(source, targetClass);
	}
	

	public static <S, T> T convertToEntity(S source, Class<T> targetClass) {
		  return modelMapper.map(source, targetClass);
	}
}

