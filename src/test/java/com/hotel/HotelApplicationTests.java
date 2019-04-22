package com.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelApplicationTests {

	@Autowired
	private RoomRepository roomRepo;
}
