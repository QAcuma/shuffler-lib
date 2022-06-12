package ru.acuma.shufflerlib.model.web.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.acuma.shufflerlib.model.web.entity.WebError;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class ErrorData {

    private WebError error;

}
