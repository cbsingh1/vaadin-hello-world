package com.cbsingh.hellovaadinflow.post;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("posts")
class PostsView extends Div {
    public PostsView(final PostService postService) {
        setHeightFull();
        Grid<Post> grid = new Grid<>(Post.class);
        grid.setHeightFull();
        grid.setItems(postService.findAll());
        add(grid);
    }
}
