package com.cookub.backend.controller;

import java.util.List;

import com.cookub.backend.dto.CookMethodDto;
import com.cookub.backend.dto.IngredientDto;
import com.cookub.backend.dto.KeywordDto;
import com.cookub.backend.dto.RecipeDto;
import com.cookub.backend.entity.CookMethod;
import com.cookub.backend.entity.Ingredient;
import com.cookub.backend.entity.Keyword;
import com.cookub.backend.entity.Recipe;
import com.cookub.backend.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/mypage")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    /////////////////////// 등록//////////////////////////
    // 레시피 정보 등록
    @RequestMapping(value = "/recipe/{userId}", method = RequestMethod.POST)
    public void setRecipe(@RequestBody RecipeDto recipeDto, @PathVariable Long userId) {
        recipeService.setRecipe(recipeDto, userId);
    }

    // 내 레시피 목록 조회
    @GetMapping("/recipe/list/{userId}")
    public List<Recipe> myRecipe(@PathVariable("userId") Long userId) {
        return recipeService.myRecipe(userId);
    }

    // 레시피 '상세' 정보 조회
    @GetMapping("/recipe/{recipeId}")
    public Recipe findRecipe(@PathVariable("recipeId") long recipeId) {
        return recipeService.findRecipe(recipeId);
    }

    // 레시피 정보 수정
    @RequestMapping(value = "/recipe/{recipeId}", method = RequestMethod.PUT)
    public String putRecipe(@RequestBody RecipeDto recipeDto, @PathVariable Long recipeId) {
        recipeService.putRecipe(recipeDto, recipeId);
        return "redirect:/";
    }

    // 내 레시피 삭제
    @RequestMapping(value = "/recipe/{recipeId}", method = RequestMethod.DELETE)
    public String recipeDelete(@RequestBody RecipeDto recipeDto, @PathVariable("recipeId") long recipeId) {
        return recipeService.delRecipe(recipeId);
    }

}