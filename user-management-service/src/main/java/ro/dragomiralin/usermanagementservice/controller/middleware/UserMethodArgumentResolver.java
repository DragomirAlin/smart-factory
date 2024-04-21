package ro.dragomiralin.usermanagementservice.controller.middleware;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ro.dragomiralin.usermanagementservice.dto.UserContext;

@RequiredArgsConstructor
public class UserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private final UserResolver resolver;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserContext.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        return resolver.getUser();
    }
}
