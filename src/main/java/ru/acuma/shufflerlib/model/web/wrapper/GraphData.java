package ru.acuma.shufflerlib.model.web.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.acuma.shufflerlib.model.web.entity.WebGraph;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GraphData extends WebPayload {

    private final List<WebGraph> graphs;

}
