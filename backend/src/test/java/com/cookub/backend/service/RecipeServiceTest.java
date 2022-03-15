package com.cookub.backend.service;

import com.cookub.backend.dto.RecipeDto;
import com.cookub.backend.entity.CookMethod;
import com.cookub.backend.entity.Ingredient;
import com.cookub.backend.entity.Keyword;
import com.cookub.backend.entity.Recipe;
import com.cookub.backend.entity.User;
import com.cookub.backend.repository.CookMethodRepository;
import com.cookub.backend.repository.IngredientRepository;
import com.cookub.backend.repository.KeywordRepository;
import com.cookub.backend.repository.RecipeRepository;
import com.cookub.backend.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    CookMethodRepository cookMethodRepository;

    @Autowired
    KeywordRepository keywordRepository;

    @Autowired
    UserRepository userRepository;
    
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
        // assertTrue() assertEquals()

    // 레시피 등록 테스트
    @Test
    void setRecipe(RecipeDto recipeDto) {
        Recipe recipeEntity = Recipe.builder()
                .title("dd")
                .keypoint("20d")
                .isOpenable(1)
                .level("상")
                .cookingTime(1)
                .likeCnt(0)
                .views(0)
                .ingredients(null)
                .keywordList(null)
                .cookMethods(null)
                // ingredients:[{"ingredientName":"재료1","amount":10},{"ingredientName":"재료2","amount":50}],
                // keywordList:[{"keywordName":"키워드1"},{"keywordName":"키워드2"}]
                // .cookMethods(recipeDto.getCookMethods();
                .build();
        recipeEntity = recipeRepository.save(recipeEntity);
        for (CookMethod cookMethod : recipeDto.getCookMethods()) {
            cookMethod.setMethodRecipe(recipeEntity);
            cookMethodRepository.save(cookMethod);
        }
        for (Keyword keyword : recipeDto.getKeywordList()) {
            keyword.setKeywordRecipe(recipeEntity);
            keywordRepository.save(keyword);
        }
        for (Ingredient ingredient : recipeDto.getIngredients()) {
            ingredient.setIngredientRecipe(recipeEntity);
            ingredientRepository.save(ingredient);
        }

    }

    // 레시피 수정 테스트
    @Test
    void putRecipe() {
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
        // assertTrue() assertEquals()

    }

    // 레시피 목록 조회 테스트
    @Test
    void myRecipe() {
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
        // assertTrue() assertEquals()

    }

    // 레시피 상세 정보 조회 테스트
    @Test
    void findRecipe() {
        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
        // assertTrue() assertEquals()

    }

    // 레시피 삭제 테스트
    @Test
    void delRecipe() {

        recipeRepository.deleteById(30L);
        // cascade 사용하였을 경우, 삭제 완료 되었음.
        // 이후, 값 다시 넣을 경우, null로 입력되므로, 점검 필요 

        // Tip! RED->GREEN->Refactoring

        // given : 무언가가 주어졌을 때,

        // when : 이 상황에

        // then : 이 결과가 나와야한다.
        // assertThat("결과값").isEqualTo("예상결과값");
        // assertTrue() assertEquals()

    }

}