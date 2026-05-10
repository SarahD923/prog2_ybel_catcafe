package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CatCafeTest {

    @Test
    void givenEmptyCafe_whenGetCatCount_thenReturnsZero() {

        CatCafe cafe = new CatCafe();

        long count = cafe.getCatCount();

        assertEquals(0, count);
    }

    @Test
    void givenEmptyCafe_whenAddOneCat_thenCountIsOne() {

        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Morticia", 3);

        cafe.addCat(cat);

        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void givenCafeWithThreeCats_whenGetCatCount_thenReturnsThree() {

        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Morticia", 3));
        cafe.addCat(new FelineOverLord("Sooky", 2));
        cafe.addCat(new FelineOverLord("Fitzby", 5));

        assertEquals(3, cafe.getCatCount());
    }

    @Test
    void givenCafeWithCat_whenGetCatByExistingName_thenReturnsThatCat() {

        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Morticia", 3);
        cafe.addCat(cat);

        FelineOverLord result = cafe.getCatByName("Morticia");

        assertSame(cat, result);
    }

    @Test
    void givenCafeWithCats_whenGetCatByMissingName_thenReturnsNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        FelineOverLord result = cafe.getCatByName("Garfield");

        assertNull(result);
    }

    @Test
    void givenCafeWithCats_whenGetCatByNullName_thenReturnsNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        FelineOverLord result = cafe.getCatByName(null);

        assertNull(result);
    }

    @Test
    void givenCafeWithCats_whenGetCatByWeightInsideRange_thenReturnsMatchingCat() {

        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Fitzby", 5);
        cafe.addCat(cat);

        FelineOverLord result = cafe.getCatByWeight(5, 6);

        assertSame(cat, result);
    }

    @Test
    void givenCafeWithCats_whenGetCatByWeightAtLowerBoundary_thenReturnsCat() {

        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Sooky", 2);
        cafe.addCat(cat);

        FelineOverLord result = cafe.getCatByWeight(2, 4);

        assertSame(cat, result);
    }

    @Test
    void givenCafeWithCats_whenGetCatByWeightAtUpperBoundary_thenReturnsNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        FelineOverLord result = cafe.getCatByWeight(1, 3);

        assertNull(result);
    }

    @Test
    void givenCafeWithCats_whenGetCatByWeightWithNegativeMinimum_thenReturnsNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        FelineOverLord result = cafe.getCatByWeight(-1, 4);

        assertNull(result);
    }

    @Test
    void givenCafeWithCats_whenGetCatByWeightWithMaxSmallerThanMin_thenReturnsNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        FelineOverLord result = cafe.getCatByWeight(5, 3);

        assertNull(result);
    }

    @Test
    void givenEmptyCafe_whenAddNullCat_thenThrowsNullPointerException() {

        CatCafe cafe = new CatCafe();

        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }
}
