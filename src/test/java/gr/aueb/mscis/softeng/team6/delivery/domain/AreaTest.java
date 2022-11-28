package gr.aueb.mscis.softeng.team6.delivery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AreaTest {
  @Test
  void testSetZipCodeValid() {
    assertThat(new Area().setZipCode("104 34")).returns(10434, Area::getZipCode);
  }

  @Test
  void testSetZipCodeInvalid() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> new Area().setZipCode("NaN"));
  }

  @Test
  void testToString() {
    var area = new Area().setCity("Athina").setState("Attica").setZipCode(11362);
    assertThat(area).hasToString("Area{city=\"Athina\", state=\"Attica\", zipCode=11362}");
  }

  @Test
  void checkIfNull() {
    Area area = new Area().setCity("Athina").setState("Attica").setZipCode(11362);
    assertNotNull(area);
  }

  @Test
  void checkIfFieldsNull() {
    Area area = new Area().setCity(null).setState(null).setZipCode(11362);
    assertNull(area.getCity());
    assertNull(area.getState());
  }
}
