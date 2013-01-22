class Action
    counter = 0
    
    constructor: ->

    createNext: ->
        c = $("#todos_x__action_id").clone()
        c.attr("id", "#todos_" + counter + "__action_id")
        c.attr("name", "todos[" + counter + "].action.id")
        return c;    
    
action = new Action()

$(document).ready -> 
    $("body").append(action.createNext())

    