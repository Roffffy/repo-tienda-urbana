package com.tienda_urbana.catalogo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tienda_urbana.catalogo.model.Categoria;
import com.tienda_urbana.catalogo.model.Producto;
import com.tienda_urbana.catalogo.repository.CategoriaRepository;
import com.tienda_urbana.catalogo.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @Override
    public void run(String... args) {

        if (categoriaRepository.count() > 0) {
            log.info("La Base de Datos ya cuenta con registros. Omitiendo carga de datos...");
            return;
        }

        Categoria categoria1 = categoriaRepository
            .save(new Categoria(null, "Poleras"));

        Categoria categoria2 = categoriaRepository
            .save(new Categoria(null, "Pantalones"));

        @SuppressWarnings("unused")
        Producto producto1 = productoRepository
            .save(new Producto(null, "Polera blanca sin mangas", null, 29990, "M", null, 10, categoria1));

        @SuppressWarnings("unused")
        Producto producto2 = productoRepository.save(new Producto(null, "Pantalon Jeans Tiro Bajo", null, 24990, "M", null, 20, categoria2));
    }
}
