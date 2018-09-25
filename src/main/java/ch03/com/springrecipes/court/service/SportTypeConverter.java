package ch03.com.springrecipes.court.service;

import ch03.com.springrecipes.court.domain.SportType;
import org.springframework.core.convert.converter.Converter;

public class SportTypeConverter implements Converter<String, SportType> {

    private ReservationService reservationService;

    public SportTypeConverter(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @Override
    public SportType convert(String source) {
        int sportTypeId = Integer.parseInt(source);
        SportType sportType = reservationService.getSportType(sportTypeId);
        return sportType;
    }
}
