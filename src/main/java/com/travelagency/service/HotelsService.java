package com.travelagency.service;

import com.travelagency.dao.HotelsDAO;
import com.travelagency.entity.HotelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ace on 07/07/2017.
 */
@Service
public class HotelsService {

    private HotelsDAO hotelsDAO;

    @Autowired
    public void setHotelsDAO(HotelsDAO hotelsDAO) {
        this.hotelsDAO = hotelsDAO;
    }

    public void addHotel(HotelEntity hotel) {
        hotelsDAO.addEntity(hotel);
    }

    public void updateHotel(HotelEntity hotel) {
        hotelsDAO.updateEntity(hotel);
    }

    public HotelEntity getCustomerById(Integer hotelId) {
        return hotelsDAO.getEntityByID(hotelId);
    }

    public List<HotelEntity> getHotelsByColumnNameAndValue(String columnName, Object value) {
        return hotelsDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    public List<HotelEntity> getAllHotels() {
        return hotelsDAO.getAllEntities();
    }

    public void deleteHotel(HotelEntity hotel) {
        hotelsDAO.deleteEntity(hotel);
    }
}
