package edu.wctc.mvcworddictionary;

import edu.wctc.mvcworddictionary.entity.Word;
import edu.wctc.mvcworddictionary.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
//@RequestMapping("/dictionary")
public class DictionaryController {
    private WordListService wordListService;

    @Autowired
    public DictionaryController(WordListService wls) {
        this.wordListService = wls;
    }

    @RequestMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("pageTitle","The Word Dictionary");
        model.addAttribute("words", wordListService.getWords());
        return "index";
    }

    @RequestMapping("/searchWord")
    public String showForm(Model model){
        model.addAttribute("pageTitle", "Enter Your Word");

        model.addAttribute("words", wordListService.getWords());
        Word defaultWord=new Word();
        defaultWord.setWord("egg");
        defaultWord.setDefinition("a definition");
        model.addAttribute("word", defaultWord);

        return "searchWord";
    }



    @GetMapping("/{word}")
    public String showDefinition(@PathVariable("word") String word, Model model){
        model.addAttribute("word",word);
        model.addAttribute("definition",wordListService.getWord(word));
        return "definition";
    }

    @PostMapping("/definition")
    public String showSearch(@RequestParam(name="wordSearch") String word, Model model){

        model.addAttribute("word",word);
        model.addAttribute("definition",wordListService.getWord(word));
        return "definition";
    }






}
