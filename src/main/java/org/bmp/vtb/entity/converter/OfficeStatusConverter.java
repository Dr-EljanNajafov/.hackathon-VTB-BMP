package org.bmp.vtb.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.bmp.vtb.entity.Office;

import java.util.Arrays;

@Converter
public class OfficeStatusConverter implements AttributeConverter<Office.Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Office.Status status) {
        return status.getId();
    }

    @Override
    public Office.Status convertToEntityAttribute(Integer integer) {
        return Arrays.stream(Office.Status.values()).filter(status -> status.getId() == integer).findFirst().orElseThrow();
    }
}
