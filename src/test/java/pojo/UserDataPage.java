package pojo;

import java.util.List;

public record UserDataPage(
        Integer page,
        Integer per_page,
        Integer total,
        Integer total_pages,
        List<UserData> data,
        Support support
) {
}
