package com.siva.tacocloud;

//import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.siva.tacocloud.Ingredient.Type;
import com.siva.tacocloud.data.IngredientRepository;
import com.siva.tacocloud.data.TacoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private TacoRepository tacoRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo,TacoRepository tacoRepo){
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @ModelAttribute(name="order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name="taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model){
        /*List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO","Flour Tortilla",Type.WRAP),
            new Ingredient("COTO","Corn Tortilla",Type.SAUCE),
            new Ingredient("GREF","Ground Beef",Type.CHEESE),
            new Ingredient("CARN","Carnitas",Type.PROTEIN),
            new Ingredient("CORN","Corn",Type.SAUCE),
            new Ingredient("GROU","Ground",Type.CHEESE),
            new Ingredient("CRNI","Carnit",Type.PROTEIN),
            new Ingredient("DICE","Diced Tomat",Type.VEGGIES)
        );*/

        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();

        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(),
                ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList())
            );
        }

        model.addAttribute("design",new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design,Errors errors,@ModelAttribute Order order){

        if(errors.hasErrors()){
            return "design";
        }

        log.info("Processing Design" + tacoRepo.save(design));

        return "redirect:/orders/current";
    }

}
