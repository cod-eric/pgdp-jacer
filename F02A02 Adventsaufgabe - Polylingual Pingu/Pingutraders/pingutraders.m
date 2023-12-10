classdef pingutraders
  properties (Access = private)
    Capacity
  end

  methods (Access = public)
    function obj = pingutraders(Capacity)
    % Constructor for pingutraders, takes a Capacity for fish
      obj.Capacity = Capacity;
    end

    function map = deliverFish(obj, map)
    % penguin trader trying to deliverFish, takes a calling obj and 
    % a 2D array as the map
      filtered = map;
      filtered(filtered>obj.Capacity) = 0;

      if(any(filtered(:)))
        [x,y] = find(filtered);
        i = randi(length(x));
        map(x(i),y(i)) = 0;
      end
    end

    function obj = cooperate(obj, other)
    % lets to penguins cooperate to increase their capacity
      obj.Capacity += other.Capacity;
    end

    function dispPingutraders(obj)
      fprintf("Capacity: %d \n", obj.Capacity);
    end
  end
end
