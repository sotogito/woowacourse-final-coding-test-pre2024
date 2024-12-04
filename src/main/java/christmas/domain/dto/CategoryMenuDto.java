package christmas.domain.dto;

import christmas.constant.Category;
import christmas.domain.restaurant.MenuItem;

public record CategoryMenuDto(Category category, MenuItem menuItem) {
}
