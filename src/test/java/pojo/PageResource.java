package pojo;

import java.util.List;

public record PageResource(
        Integer page,
        Integer per_page,
        Integer total,
        Integer total_pages,
        List<ListResource> data,
        Support support
) {
}
