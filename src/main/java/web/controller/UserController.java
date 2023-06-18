package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/pagesCrud")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String displayAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "pagesCrud/displayAll";
    }

    @GetMapping("/{id}")
    public String displayUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userService.getUser(id));
        return "pagesCrud/displayUser";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "pagesCrud/add";
    }

    @PostMapping()
    public String add(@ModelAttribute("person") User user,
                      BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "pagesCrud/add";

        userService.add(user);
        return "redirect:/pagesCrud";
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", userService.getUser(id));
        return "pagesCrud/edit";
    }

    @PatchMapping("/{id}") //@Valid
    public String update(@ModelAttribute("person") User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "pagesCrud/edit";
        userService.update(id, user);
        return "redirect:/pagesCrud";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/pagesCrud";
    }
}

