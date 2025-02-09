insert into roles (name) values 
    ('Администратор'),
    ('Модератор'),
    ('Пользователь');

insert into rules (name) values 
    ('Создание заявки'),
    ('Редактирование заявки'),
    ('Удаление заявки'),
    ('Комментирование заявки'),
    ('Прикрепление файлов');

insert into role_rules (role_id, rule_id) values 
    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), 
    (2, 1), (2, 2), (2, 4), (2, 5), 
    (3, 1), (3, 4), (3, 5); 

insert into users (name, email, role_id) values 
    ('Альберт', 'feyour@gmail.com', 1),
    ('Вадим', 'vadim@gmail.com', 2), 
    ('Константин', 'konst@gmail.com', 3), 
    ('Алексей', 'alex@gmail.com', 3);

insert into categories (name) values 
    ('Технической вопрос'),
    ('Предложения'),
    ('Жалобы');

INSERT INTO states (name) values 
    ('Открыта'),
    ('В работе'),
    ('Обработана');

insert into items (title, user_id, state_id, category_id) values 
    ('Ошибка', 3, 1, 1),
    ('Предложен новый функционал', 4, 1, 2), 
    ('Жалоба', 3, 1, 3); 

insert into comments (text, item_id) values 
    ('Просьба ускорить процесс проверки', 1);

insert into attachs (filename, item_id) values 
    ('screenshot.jpeg', 1);
