package pl.bykowski.springbootdbtwitter;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("add-pigeon")
public class PigeonAddView extends VerticalLayout {

    private PigeonRepo pigeonRepo;

    @Autowired
    public PigeonAddView(PigeonRepo pigeonRepo) {
        this.pigeonRepo = pigeonRepo;

        TextField textFieldName = new TextField();
        TextField textFieldColor = new TextField();
        TextField textFieldNumber = new TextField();

        Button button = new Button("Save");

        button.addClickListener(buttonClickEvent -> {
            Pigeon pigeon = new Pigeon(textFieldName.getValue(), textFieldColor.getValue(), textFieldNumber.getValue());
            pigeonRepo.save(pigeon);
            add(new Image("https://media.giphy.com/media/l0HlvnvyGKfetZDXO/giphy.gif", ""));
        });

        add(textFieldName, textFieldColor, textFieldNumber, button);


    }
}
