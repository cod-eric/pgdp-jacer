% cleaning up the workspace
clear
clear classes

% initialisation of the pingutraders
ntraders = 20;
map =  zeros(20,10);
randomindices = randi(length(map(:)), 1, ntraders);
map(randomindices) += 1;

for i = 1:ntraders
  traderlist(i) = pingutraders(1);
end

% choose which penguins to merge into a new penguin with more capacity
while(true)
  disp("Your current penguins have the following capacities: \n")
  for i = 1:length(traderlist)
    dispPingutraders(traderlist(i));
  end

  response = input("Merge two penguins [0] or continue with the fish delivery [1]? \n");
  if(response ~= 0)
    break;
  end

  i = input("Input first index to merge: \n");
  j = input("Input second index to merge: \n");

  if(i==j)
    disp("You cannot merge a penguin with itself! \n");
  elseif(i<=length(traderlist) &j<=length(traderlist) &
  0<i & 0<j)
    traderlist(i) = cooperate(traderlist(i),traderlist(j));
    traderlist = traderlist(1:length(traderlist)~=j);
  else
    disp("Pengu-Index out of bounds\n");
  end
end


% delivery cycles of the pingutraders
ncycle = 1;
while (true)
  disp("This is the current demand of fish in the region: \n");
  disp(map);
  
  for i = 1:length(traderlist)
    map = deliverFish(traderlist(i), map);
  end

  response = input("Input options are to continue [0] or to quit [1] \n");
  switch response
    case 0
      randomindices = randi(length(map(:)),
      1,
      length(traderlist)+ncycle++);
      map(randomindices) += 1;
      continue;
    case 1
      break;
    otherwise
      error("Invalid input");
  end
end
