INSERT INTO public.roles
(role_id, role_name)
VALUES(1, 'ADMIN');
INSERT INTO public.roles
(role_id, role_name)
VALUES(2, 'CUSTOMER');

INSERT INTO public.accounts
(account_id, email, "password",role_id)
VALUES(7, 'admin@gmail.com', '$2a$10$Z90Vo4bSNLhvifpq6eqF.OjCngYLv65hTn7QVngedz8g4r4vYsh6.',1);
INSERT INTO public.accounts
(account_id, email, "password",role_id)
VALUES(10, 'anthony@gmail.com', '$2a$10$ax5PL8Zfrajt48qlm6OT0enq4XFGrYxK6eCF4L9xWHdfeVNYeb55a',2);
INSERT INTO public.accounts
(account_id, email, "password",role_id)
VALUES(11, 'simon@gmail.com', '$2a$10$a/SGBo4iWQgHuKcx8QNS3.XRMmDgPmhRpBCIZv2PEAIKMVHD7oxF.',2);
INSERT INTO public.accounts
(account_id, email, "password",role_id)
VALUES(12, 'tranminhkhang@gmail.com', '$2a$10$/6XE74FmauFskpvfWHTH2uDrpUoPYxq6fjv/7BH7SrhCeyJ5CjdI6',1);




INSERT INTO public.genres
(genre_id, genre_name)
VALUES(1, 'fiction');
INSERT INTO public.genres
(genre_id, genre_name)
VALUES(2, 'non-fiction');
INSERT INTO public.genres
(genre_id, genre_name)
VALUES(3, 'thriller');
INSERT INTO public.genres
(genre_id, genre_name)
VALUES(4, 'romance');
INSERT INTO public.genres
(genre_id, genre_name)
VALUES(7, 'young adult');
INSERT INTO public.genres
(genre_id, genre_name)
VALUES(14, 'art');
INSERT INTO public.genres
(genre_id, genre_name)
VALUES(15, 'sci-fi');

INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(11, 'Barack Obama', 'A riveting, deeply personal account of history in the making, from the president who inspired us to believe in the power of democracy.
In the stirring, highly anticipated first volume of his presidential memoirs, Barack Obama tells the story of his improbable odyssey from young man searching for his identity to leader of the free world, describing in strikingly personal detail both his political education and the landmark moments of the first term of his historic presidency—a time of dramatic transformation and turmoil.', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1600357110l/55361205._SY475_.jpg', 35.65, 'All IndieLit.', 77, 'disabled', 'A Promised Land');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(13, 'Barack Obama', 'A riveting, deeply personal account of history in the making, from the president who inspired us to believe in the power of democracy.
In the stirring, highly anticipated first volume of his presidential memoirs, Barack Obama tells the story of his improbable odyssey from young man searching for his identity to leader of the free world, describing in strikingly personal detail both his political education and the landmark moments of the first term of his historic presidency—a time of dramatic transformation and turmoil.', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1600357110l/55361205._SY475_.jpg', 35.65, 'All IndieLit.', 80, 'disabled', 'A Promised Land');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(12, 'Barack Obama', 'A riveting, deeply personal account of history in the making, from the president who inspired us to believe in the power of democracy.
In the stirring, highly anticipated first volume of his presidential memoirs, Barack Obama tells the story of his improbable odyssey from young man searching for his identity to leader of the free world, describing in strikingly personal detail both his political education and the landmark moments of the first term of his historic presidency—a time of dramatic transformation and turmoil.', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1600357110l/55361205._SY475_.jpg', 35.65, 'All IndieLit.', 76, 'disabled', 'This is not A Promised Land');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(10, 'Barack Obama', 'A riveting, deeply personal account of history in the making, from the president who inspired us to believe in the power of democracy.
In the stirring, highly anticipated first volume of his presidential memoirs, Barack Obama tells the story of his improbable odyssey from young man searching for his identity to leader of the free world, describing in strikingly personal detail both his political education and the landmark moments of the first term of his historic presidency—a time of dramatic transformation and turmoil.', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1600357110l/55361205._SY475_.jpg', 35.65, 'All IndieLit.', 79, 'active', 'A Promised Land');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(56, 'khang', '', 'https://firebasestorage.googleapis.com/v0/b/spring-react-learning.appspot.com/o/images%2F36387113._SY475_.jpg04b5188f-6dbc-43ad-a6b5-87c58664e84e?alt=media&token=cb623902-893f-43c8-a5cd-19a20a28ff24', 0.0, 'khang', 0, 'active', '');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(54, 'J.D. Vance', 'Hillbilly Elegy is a passionate and personal analysis of a culture in crisis—that of white working-class Americans. The disintegration of this group, a process that has been slowly occurring now for more than forty years, has been reported with growing frequency and alarm, but has never before been written about as searingly from the inside. J. D. Vance tells the true story of what a social, regional, and class decline feels like when you were born with it hung around your neck.

The Vance family story begins hopefully in postwar America. J. D.’s grandparents were “dirt poor and in love,” and moved north from Kentucky’s Appalachia region to Ohio in the hopes of escaping the dreadful poverty around them. They raised a middle-class family, and eventually one of their grandchildren would graduate from Yale Law School, a conventional marker of success in achieving generational upward mobility. But as the family saga of Hillbilly Elegy plays out, we learn that J.D.''s grandparents, aunt, uncle, sister, and, most of all, his mother struggled profoundly with the demands of their new middle-class life, never fully escaping the legacy of abuse, alcoholism, poverty, and trauma so characteristic of their part of America. With piercing honesty, Vance shows how he himself still carries around the demons of his chaotic family history.

A deeply moving memoir, with its share of humor and vividly colorful figures, Hillbilly Elegy is the story of how upward mobility really feels. And it is an urgent and troubling meditation on the loss of the American dream for a large segment of this country.', 'https://firebasestorage.googleapis.com/v0/b/spring-react-learning.appspot.com/o/images%2F27161156.jpege56a6347-c49c-4bab-9866-84663a102468?alt=media&token=03c70b81-d40d-4232-af3a-fd9421508699', 22.85, 'Penguine', 64, 'active', 'Hillbilly Elegy: A Memoir of a Family and Culture in Crisis');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(53, 'Tara Westover', 'Tara Westover was 17 the first time she set foot in a classroom. Born to survivalists in the mountains of Idaho, she prepared for the end of the world by stockpiling home-canned peaches and sleeping with her "head-for-the-hills bag". In the summer she stewed herbs for her mother, a midwife and healer, and in the winter she salvaged in her father''s junkyard.

Her father forbade hospitals, so Tara never saw a doctor or nurse. Gashes and concussions, even burns from explosions, were all treated at home with herbalism. The family was so isolated from mainstream society that there was no one to ensure the children received an education and no one to intervene when one of Tara''s older brothers became violent.

Then, lacking any formal education, Tara began to educate herself. She taught herself enough mathematics and grammar to be admitted to Brigham Young University, where she studied history, learning for the first time about important world events like the Holocaust and the civil rights movement. Her quest for knowledge transformed her, taking her over oceans and across continents, to Harvard and to Cambridge. Only then would she wonder if she''d traveled too far, if there was still a way home.

Educated is an account of the struggle for self-invention. It is a tale of fierce family loyalty and of the grief that comes with severing the closest of ties. With the acute insight that distinguishes all great writers, Westover has crafted a universal coming-of-age story that gets to the heart of what an education is and what it offers: the perspective to see one''s life through new eyes and the will to change it.', 'https://firebasestorage.googleapis.com/v0/b/spring-react-learning.appspot.com/o/images%2Fimg2.jpegb00b449c-708d-47f4-b3ac-a057fd979e5e?alt=media&token=a102e07e-1ff6-4023-96c2-d50c2d51ea58', 12.0, 'Penguine', 82, 'active', 'Educated');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(52, 'Trevor Noah', 'The memoir of one man’s coming-of-age, set during the twilight of apartheid and the tumultuous days of freedom that followed.

Trevor Noah’s unlikely path from apartheid South Africa to the desk of The Daily Show began with a criminal act: his birth. Trevor was born to a white Swiss father and a black Xhosa mother at a time when such a union was punishable by five years in prison. Living proof of his parents’ indiscretion, Trevor was kept mostly indoors for the earliest years of his life, bound by the extreme and often absurd measures his mother took to hide him from a government that could, at any moment, steal him away. Finally liberated by the end of South Africa’s tyrannical white rule, Trevor and his mother set forth on a grand adventure, living openly and freely and embracing the opportunities won by a centuries-long struggle.

Born a Crime is the story of a mischievous young boy who grows into a restless young man as he struggles to find himself in a world where he was never supposed to exist. It is also the story of that young man’s relationship with his fearless, rebellious, and fervently religious mother—his teammate, a woman determined to save her son from the cycle of poverty, violence, and abuse that would ultimately threaten her own life. ', 'https://firebasestorage.googleapis.com/v0/b/spring-react-learning.appspot.com/o/images%2F29780253.jpeg061384cb-9a74-4571-ad91-fc2ad166e157?alt=media&token=021c0026-7bc6-4da9-8727-4967f15f3848', 15.65, 'NoPublisher', 60, 'active', 'Born a Crime: Stories From a South African Childhood');
INSERT INTO public.books
(book_id, author, description, image_link, price, publisher, quantity_left, status, title)
VALUES(55, 'Becky Albertalli', 'Sixteen-year-old and not-so-openly Simon Spier prefers to save his drama for the school musical. But when an email falls into the wrong hands, his secret is at risk of being thrust into the spotlight. Now Simon is actually being blackmailed: if he doesn’t play wingman for class clown Martin, his sexual identity will become everyone’s business. Worse, the privacy of Blue, the pen name of the boy he’s been emailing, will be compromised.

With some messy dynamics emerging in his once tight-knit group of friends, and his email correspondence with Blue growing more flirtatious every day, Simon’s junior year has suddenly gotten all kinds of complicated. Now, change-averse Simon has to find a way to step out of his comfort zone before he’s pushed out—without alienating his friends, compromising himself, or fumbling a shot at happiness with the most confusing, adorable guy he’s never met.', 'https://firebasestorage.googleapis.com/v0/b/spring-react-learning.appspot.com/o/images%2F19547856.jpeg0084a281-59a6-47fd-a934-3af9be332027?alt=media&token=cff2a509-c13e-454a-be09-73313ade8ce8', 35.0, 'No publisher', 80, 'active', 'Simon vs. the Homo Sapiens Agenda');




INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(586, 53, 1);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(587, 53, 2);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(588, 53, 3);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(589, 54, 1);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(590, 54, 2);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(591, 54, 3);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(592, 12, 1);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(593, 12, 2);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(594, 12, 3);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(595, 55, 1);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(596, 55, 2);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(597, 55, 3);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(601, 10, 1);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(602, 10, 2);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(603, 10, 3);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(604, 56, 1);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(605, 56, 2);
INSERT INTO public.book_genre
(book_genre_id, book_id, genre_id)
VALUES(606, 56, 3);




INSERT INTO public.customers
(customer_id, birthday, gender, "name", status)
VALUES(7, '2002-12-12', 'male', 'Admin', 'active');
INSERT INTO public.customers
(customer_id, birthday, gender, "name", status)
VALUES(10, '2002-11-10', 'male', 'Anthony Doerr', 'active');
INSERT INTO public.customers
(customer_id, birthday, gender, "name", status)
VALUES(11, '2002-11-10', 'male', 'Simon Spier', 'active');
INSERT INTO public.customers
(customer_id, birthday, gender, "name", status)
VALUES(12, '2022-03-23', 'male', 'Khang', 'disabled');


INSERT INTO public.comments
(comment_id, "content", rating, "timestamp", book_id, customer_id)
VALUES(21, 'hello this is 4 stars', 4.0, '2022-11-09 19:51:25.168', 54, 11);
INSERT INTO public.comments
(comment_id, "content", rating, "timestamp", book_id, customer_id)
VALUES(22, 'this is 1 star', 1.0, '2022-11-09 19:51:44.417', 54, 11);
INSERT INTO public.comments
(comment_id, "content", rating, "timestamp", book_id, customer_id)
VALUES(23, '5 stars', 5.0, '2022-11-10 14:51:24.330', 54, 12);



INSERT INTO public.orders
(order_id, address, phone, status, "time", total_amount, customer_id)
VALUES(39, 'Thu Duc City, HCM City', '0363111012', 'pending', '2020-12-12 07:00:00.000', 137.2, 11);
INSERT INTO public.orders
(order_id, address, phone, status, "time", total_amount, customer_id)
VALUES(40, 'me', 'take', 'pending', '2022-11-09 15:36:28.465', 78.95, 11);
INSERT INTO public.orders
(order_id, address, phone, status, "time", total_amount, customer_id)
VALUES(41, 'Thu Duc City, HCM City', '0363111012', 'pending', '2020-12-12 07:00:00.000', 137.2, 11);
INSERT INTO public.orders
(order_id, address, phone, status, "time", total_amount, customer_id)
VALUES(42, '123', '123', 'pending', '2022-11-09 19:48:56.683', 45.7, 11);
INSERT INTO public.orders
(order_id, address, phone, status, "time", total_amount, customer_id)
VALUES(43, '456', '123', 'pending', '2022-11-10 13:07:52.475', 22.85, 11);
INSERT INTO public.orders
(order_id, address, phone, status, "time", total_amount, customer_id)
VALUES(44, '678910', '12345', 'pending', '2022-11-10 13:09:24.526', 66.15, 11);
INSERT INTO public.orders
(order_id, address, phone, status, "time", total_amount, customer_id)
VALUES(45, 'Thu Duc HCM', '0933111098', 'pending', '2022-11-10 14:53:55.799', 0.0, 12);



INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(39, 15.65, 8, 52, 39);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(40, 12.0, 1, 53, 39);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(41, 35.65, 1, 10, 40);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(42, 15.65, 2, 52, 40);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(43, 12.0, 1, 53, 40);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(44, 15.65, 8, 52, 41);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(45, 12.0, 1, 53, 41);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(46, 22.85, 2, 54, 42);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(47, 22.85, 1, 54, 43);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(48, 15.65, 2, 52, 44);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(49, 12.0, 1, 53, 44);
INSERT INTO public.order_details
(order_details_id, price, quantity, book_id, order_id)
VALUES(50, 22.85, 1, 54, 44);

