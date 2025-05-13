package coberturaCodigo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ejercicio.CalculadoraDescuentosUtils;
import ejercicio.Producto;

public class CalculadoraDescuentosTest {

	@Test
	public void testMuchosProductosElectronicaVIP() {
		List<Producto> productosElectronica = Arrays.asList(new Producto("electronica", 110.99, 8),
				new Producto("electronica", 89.99, 6));

		double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productosElectronica, true);
		assertEquals(1070.90, total);
	}

	@Test
	public void testPocosProductosElectronicaSinVIP() {
		List<Producto> productosElectronica = Arrays.asList(new Producto("ELECTRONICA", 100.0, 2));

		double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productosElectronica, false);

		assertEquals(180.0, total);

	}

	@Test
	public void testProductosRopaVIP() {
		List<Producto> productosRopa = Arrays.asList(new Producto("ropa", 10.8, 1), new Producto("ropa", 7.99, 4));

		double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productosRopa, true);

		assertEquals(35.29, total);

	}

	@Test
	public void testProductosHogarSinVIP() {
		List<Producto> productosHogar = Arrays.asList(new Producto("hogar", 40, 1), new Producto("hogar", 12.5, 2));

		double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productosHogar, false);

		assertEquals(62.5, total);

	}

	@Test
	public void testProductosAlimentacionVIP() {
		List<Producto> productosAlimentacion = Arrays.asList(new Producto("alimentacion", 1, 100));

		double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productosAlimentacion, true);

		assertEquals(90, total);

	}

	@Test
	public void testListaVacia() {
		List<Producto> listaVacia = new ArrayList();

		double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(listaVacia, true);

		assertEquals(0, total);
	}

	@Test
	public void testCategoriaNoValida() {
		List<Producto> categoriaNoValida = Arrays.asList(new Producto("deportes", 39.99, 2));

		assertThrows(IllegalArgumentException.class, () -> {
			CalculadoraDescuentosUtils.calcularTotalConDescuento(categoriaNoValida, true);
		});
	}

}
