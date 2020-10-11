insert into event values ('Science','Space Exploration');
insert into event values ('Maths','Patterns');
insert into event values ('Medical','Human Body');

insert into event_details ('Earth' , 1);
insert into event_details ('Mars' , 1);
insert into event_details ('Moon' , 1);
insert into event_details ('Sun' , 1);

insert into event_details ('Radio Waves' , 2);
insert into event_details ('Weather Prediction' , 2);

insert into event_details ('Eyes-Ratina' , 3);
insert into event_details ('lungs-corona' , 3);
insert into event_details ('Mind-Neurons' , 3);

insert into registered_event (sysdate(), 'Mars', 'Science', 'Space Exploration');
insert into registered_event (sysdate(), 'Radio Waves', 'Maths', 'Patterns');
insert into registered_event (sysdate(), 'lungs-corona', 'Medical', 'Space Exploration');
 
