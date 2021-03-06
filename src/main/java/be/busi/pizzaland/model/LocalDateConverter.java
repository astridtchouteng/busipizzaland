package be.busi.pizzaland.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Convert
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp>{
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }
}
