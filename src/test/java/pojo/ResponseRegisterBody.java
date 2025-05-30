package pojo;

public record ResponseRegisterBody(
        String email,
        String password,
        Integer id,
        String createdAt
) {
}
