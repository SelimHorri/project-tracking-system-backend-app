package com.pfa.app;

import com.pfa.app.exception.custom.ObjectNotFoundException;
import com.pfa.app.model.entity.Location;
import com.pfa.app.repository.LocationRepository;
import com.pfa.app.service.LocationService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class LocationServiceTest {

    @Mock
    private LocationService locationservice;
    @Mock
    private LocationRepository rep;

    @Nested
    class LocationServiceDeleteByIDtest {
        @Test
        public void testDeleteByExitId() {
            //Test case 1: (1,Ture)
//            LocationRepository rep = mock(LocationRepository.class);
            Location location = new Location();
            location.setLocationId(1);
            when(locationservice.findById(location.getLocationId())).thenThrow(new ObjectNotFoundException());
//            when(rep.findById(location.getLocationId())).thenReturn(Optional.of(location));
            locationservice.deleteById(location.getLocationId());
            assertThrows(ObjectNotFoundException.class, () -> {
                locationservice.findById(location.getLocationId());
            });
        }

        @Test
        public void testDeleteByNonExitId() {
            //Test case 2: (4,False)
            int targetID = 4;
            when(locationservice.findById(targetID)).thenThrow(new ObjectNotFoundException());
            assertThrows(ObjectNotFoundException.class, () -> locationservice.findById(targetID));
        }

    }

    @Nested
    class LocationServiceUpdateTest {
        @Test
        public void TestUpdateWithNullLocation() {
            //Test case 1: (Null,False)
            when(locationservice.update(null)).thenThrow(NullPointerException.class);
            assertThrows(NullPointerException.class, () -> locationservice.update(null));
        }

        @Test
        public void TestUpdate() {
            //Test case 2: (Location,Ture)
            Location targetlocation = new Location();
            when(locationservice.update(eq(targetlocation))).thenReturn(targetlocation);
            Location resultofupdate1 = locationservice.update(targetlocation);
            assertThat(resultofupdate1).isEqualTo(targetlocation);
        }

        @Test
        public void TestUpdateWitherror() {
            //Test case 3: (Location,false)
            Location targetlocation2 = new Location();
            when(locationservice.update(eq(targetlocation2))).thenThrow(JpaSystemException.class);
            assertThrows(JpaSystemException.class, () -> locationservice.update(targetlocation2));
        }

    }
}
