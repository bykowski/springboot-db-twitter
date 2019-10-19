package pl.bykowski.springbootdbtwitter;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("pigeons")
public class PigeonView extends HorizontalLayout {

    private PigeonRepo pigeonRepo;

    public PigeonView(PigeonRepo pigeonRepo) {
        this.pigeonRepo = pigeonRepo;
        Grid<Pigeon> grid = new Grid<>(Pigeon.class);
        grid.setItems(pigeonRepo.findAll());
        add(grid);


    }
}
