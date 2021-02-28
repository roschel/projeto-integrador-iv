insert into tb_brand (brand, delete) values ('Nike', false)
insert into tb_brand (brand, delete) values ('Adidas', false)
insert into tb_brand (brand, delete) values ('Puma', false)
insert into tb_brand (brand, delete) values ('Vans', false)

insert into tb_color (name) values ('preto e branco')

insert into tb_product (product, description, rating, gender, delete, price, brand_id) values ('TÊNIS AIR JORDAN 3 RETRO MASCULINO','Esse tenis é mara!', 4.76, 'masculino', false, 287.49, 1)
insert into tb_product (product, description, rating, gender, delete, price, brand_id) values ('TÊNIS NIKE AIR MAX 95 FEMININO', 'A marca do swoosh acumula ao longo de décadas muitas cartadas de sucesso dentro e fora do âmbito esportivo, e uma dessas com toda certeza inclui o lendário Tênis Nike Air Max 95. O calçado originalmente foi inspirado na anatomia do corpo humano, criado pelo designer Sergio Lozano, sendo um enorme sucesso na metade de década, onde até mesmo em meio a ascensão dos calçados de basquete, acabou literalmente roubando a cena. Desse modo, esse é um remake com o melhor que a tecnologia atual pode oferecer.', 4.76, 'feminino', false, 599.99, 1)

insert into tb_product_color (product_id, color_id) values (1, 1)
