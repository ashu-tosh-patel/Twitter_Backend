DROP DATABASE IF EXISTS TWEETDB;
CREATE DATABASE TWEETDB;
USE TWEETDB;
CREATE TABLE TWEET(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	MESSAGE VARCHAR(280) NOT NULL,
	USER_ID INT NOT NULL,
	CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tweets for Alice Johnson (userId = 1)
-- Tweets for user with ID 1
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Just started a new book on tech innovation. I’m diving into the world of AI and machine learning, and I must say, it’s fascinating to see how quickly technology is evolving. Looking forward to exploring the future of tech through these pages and applying some of these insights to my own projects!', 1),
('Had a fantastic workout this morning. The energy boost was incredible, and I’m feeling ready to tackle the rest of the day with enthusiasm. Exercise always seems to set the tone for a productive day. What’s your favorite way to start the day?', 1),
('The weekend is almost here, and I’m looking forward to some much-needed relaxation and fun. Whether it’s catching up on hobbies or spending time with loved ones, there’s something special about unwinding after a busy week. What are your plans for the weekend?', 1),
('I’m trying out a new recipe tonight, and I’m excited to see how it turns out. Cooking can be such a creative and enjoyable process, and I love experimenting with new flavors and ingredients. I’ll definitely share the results with you all!', 1),
('Had a great meeting with the team today. We discussed some exciting new projects and set goals for the coming months. It’s amazing what we can accomplish when we work together and support each other. Here’s to achieving great things ahead!', 1),
('Just finished watching a thrilling movie that kept me on the edge of my seat. The plot twists and character development were top-notch. If you’re into sci-fi and action, this one’s a must-watch. Any recommendations for my next movie night?', 1),
('Feeling incredibly grateful for all the support and encouragement I’ve received lately. It truly means a lot and makes all the difference in pushing me to do my best. Thank you to everyone who’s been there for me—your kindness doesn’t go unnoticed!', 1),
('The weather today is perfect for a hike. The sun is shining, and there’s a gentle breeze in the air. I’m looking forward to exploring some new trails and soaking in the beauty of nature. Who’s up for an outdoor adventure this weekend?', 1),
('Working on a new project that I’m really passionate about. It’s been challenging but also incredibly rewarding. I’m excited to see where it leads and can’t wait to share updates with you all. Stay tuned for more details soon!', 1),
('Enjoying a quiet evening with a cup of tea and a good book. Sometimes, the simplest pleasures are the most fulfilling. It’s a great way to unwind after a busy day and reflect on the moments that made today special.', 1);

-- Tweets for user with ID 2
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Had a productive day at work, ticking off tasks from my to-do list and making significant progress on ongoing projects. It’s such a satisfying feeling to see everything falling into place. Now, time to relax and enjoy a well-deserved evening off!', 2),
('Visited a new café today, and I must say, their coffee is absolutely amazing. The ambiance was cozy, and it made for a perfect little escape from the usual routine. If you’re ever in the area, this place is definitely worth checking out!', 2),
('Just finished a challenging workout. The intensity was high, but the results were worth it. It’s incredible how pushing your limits can lead to such a rewarding feeling. How do you keep yourself motivated to stay fit?', 2),
('Working on some exciting new designs that I’m thrilled about. It’s amazing how creativity can flow when you’re deeply immersed in a project. Can’t wait to reveal the final results and get feedback from everyone. Stay tuned!', 2),
('The city looked absolutely stunning at sunset today. The colors in the sky were breathtaking, and I managed to snap a few pictures that I’m excited to share. It’s moments like these that make you appreciate the beauty around us.', 2),
('Caught up on some reading today, diving into a book that’s been on my list for a while. There’s something so refreshing about escaping into a different world through the pages of a book. Any book recommendations for my next read?', 2),
('Enjoyed a relaxing day off today. Sometimes, you just need a break from the hustle and bustle to recharge and rejuvenate. It’s amazing how taking a step back can give you a new perspective on things.', 2),
('Just tried a new recipe for dinner, and I’m thrilled with how it turned out. Cooking has become one of my favorite ways to unwind and be creative. Can’t wait to make this dish again and maybe even experiment with some variations.', 2),
('Had a great conversation with a friend today. It’s amazing how uplifting and energizing a good chat can be. We shared stories, laughs, and made plans for the future. Grateful for moments like these that remind you of the value of friendships.', 2),
('Feeling inspired and motivated after a day full of productive work and creative brainstorming. Ready to tackle new challenges and set new goals. It’s incredible how a positive mindset can drive you toward achieving great things.', 2);

-- Tweets for user with ID 3
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Working on a creative project that’s been a passion of mine for a long time. It’s amazing to see it slowly come to life and take shape. The process is as exciting as the final result. I’m eager to share more details with you all soon!', 3),
('Had an amazing day exploring the city. Discovered some hidden gems that I didn’t know existed. It’s always fun to be a tourist in your own city and experience it from a fresh perspective. Can’t wait to go back and explore more!', 3),
('Just attended a fantastic workshop on personal development. The insights and techniques shared were incredibly valuable. Met some inspiring people who are also on a journey of growth and self-improvement. Feeling motivated and empowered!', 3),
('Spent the afternoon gardening and connecting with nature. There’s something so therapeutic about getting your hands in the soil and watching plants grow. It’s a great way to relax and unwind after a busy week.', 3),
('Trying out a new hobby today and loving every moment of it. It’s amazing how stepping out of your comfort zone can lead to new and fulfilling experiences. Looking forward to diving deeper into this new interest and seeing where it takes me.', 3),
('The team did an exceptional job on our latest project. The collaboration, dedication, and hard work really paid off. It’s incredible to see what we can achieve when we come together and put our minds to something. Proud of what we’ve accomplished!', 3),
('Looking forward to a weekend getaway to unwind and recharge. Sometimes a change of scenery is exactly what you need to refresh your mind and spirit. Planning to enjoy some downtime and take in the sights and sounds of a new place.', 3),
('Caught up on some much-needed rest today. It’s amazing how a little relaxation can rejuvenate you and prepare you for the week ahead. Feeling recharged and ready to tackle new challenges with renewed energy.', 3),
('Exploring new genres of music lately. It’s fascinating how different tunes can evoke various emotions and memories. Music has such a powerful effect on our mood and mindset. What’s a new genre or artist you’ve been into recently?', 3),
('Had a great time at a local event today. It’s wonderful to see the community come together and celebrate. The energy and enthusiasm of the crowd were contagious, and it made for a memorable experience. Looking forward to more events like this!', 3);

-- Tweets for user with ID 4
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Just finished a long day at work and feeling accomplished. It’s rewarding to see the results of hard work and dedication. Now it’s time to unwind with a delicious meal and a movie. How do you like to relax after a busy day?', 4),
('Started a new book on personal growth and development. I’m excited to dive into the concepts and strategies it covers. Personal growth is such a journey, and I’m looking forward to learning new ways to improve and grow.', 4),
('Had a productive day working on some new ideas. It’s incredible how creativity can flow when you’re deeply engaged in a project. I’m excited to see where these ideas lead and how they will take shape in the coming weeks.', 4),
('The weather today was perfect for a stroll in the park. The sun was shining, and there was a gentle breeze in the air. It’s amazing how a bit of fresh air and nature can uplift your spirits and provide a sense of tranquility.', 4),
('Tried a new workout routine today, and it was both challenging and invigorating. There’s something so satisfying about pushing yourself and achieving new fitness goals. How do you stay motivated with your workout routines?', 4),
('Visited a local art gallery today and was blown away by the exhibits. The creativity and skill on display were truly inspiring. It’s wonderful to see the talent of local artists and appreciate their unique perspectives and styles.', 4),
('Feeling grateful for the small joys in life today. It’s often the little things that bring the most happiness and contentment. Taking a moment to appreciate these simple pleasures can make a big difference in your overall well-being.', 4),
('Working on a new project that I’m passionate about. The planning stages are always exciting, and I’m eager to see how it will unfold. I’ll be sharing more updates as we progress, and I hope you’re as excited as I am!', 4),
('Had a great weekend getaway. It’s amazing how a change of scenery and a little time away from routine can be so refreshing. I’m back feeling rejuvenated and ready to take on new challenges with a fresh perspective.', 4),
('Just spent the day with family, and it was a wonderful time. Cherishing these moments together and creating memories is so important. It’s the simple things in life that often bring the most joy and fulfillment.', 4);

-- Tweets for user with ID 5
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Feeling inspired after attending a motivational seminar today. The speakers were incredible, and their stories of perseverance and success were truly uplifting. Ready to take this newfound energy and put it into action!', 5),
('Had a relaxing day at the spa today. It’s amazing how a little pampering and self-care can make a big difference. Feeling refreshed and ready to tackle the challenges of the coming week with renewed energy and positivity.', 5),
('Caught up with some old friends today. It’s always great to reconnect and reminisce about the good times. The laughter and shared memories were a wonderful reminder of the value of true friendships.', 5),
('Trying out a new recipe for dinner tonight. The ingredients look promising, and I’m excited to see how it turns out. Cooking is one of my favorite ways to unwind and be creative. I’ll share the results once I’ve finished!', 5),
('Spent the day exploring new trails and enjoying the beauty of nature. The fresh air and scenic views were exactly what I needed to recharge. There’s something so invigorating about being outdoors and disconnecting from daily stress.', 5),
('Excited about an upcoming project that’s been on my mind for a while. The planning and preparation stages are always thrilling, and I’m eager to see how everything will come together. Stay tuned for more updates!', 5),
('Enjoyed a quiet evening with some candlelit meditation. It’s amazing how calming and centering it can be to take a few moments for yourself and focus on inner peace. Feeling grounded and ready for whatever comes next.', 5),
('Had a productive brainstorming session today. We came up with some innovative ideas and solutions that I’m excited to explore further. It’s amazing what a collaborative mindset can achieve. Looking forward to putting these ideas into action!', 5),
('Visited a farmer’s market today and picked up some fresh, local produce. There’s something so satisfying about supporting local vendors and cooking with high-quality ingredients. Can’t wait to prepare some delicious meals with what I bought!', 5),
('Relaxing at home with a good book and a cup of tea. It’s the perfect way to wind down after a busy day. Sometimes, taking time for yourself and enjoying the simple things can be the most rewarding.', 5);

-- Tweets for user with ID 6
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Feeling accomplished after a successful presentation today. It was rewarding to see all the hard work and preparation pay off. Now, it’s time to relax and enjoy the evening. How do you like to unwind after a big accomplishment?', 6),
('Had a delightful afternoon exploring a new museum. The exhibits were fascinating, and I learned so much about history and art. It’s amazing how immersive experiences can broaden your horizons and provide new perspectives.', 6),
('Just completed a challenging workout session, and I’m feeling fantastic. Pushing my limits always leads to a sense of achievement and empowerment. What are your go-to activities for staying fit and motivated?', 6),
('Spending the evening with family was the highlight of my day. Cherishing these moments together and creating lasting memories is so important. It’s the little things that often make the biggest impact on our lives.', 6),
('Just discovered a new podcast series that I’m really enjoying. The topics are engaging, and the discussions are thought-provoking. Podcasts are such a great way to learn and stay informed while on the go.', 6),
('Had a productive day working on some exciting new projects. The creativity and innovation flowing through the team are inspiring. Looking forward to seeing how these projects develop and what we can achieve together!', 6),
('Enjoying a calm evening by the fireplace. There’s something so soothing about the warmth and comfort of a cozy space. Perfect way to wind down after a busy day and reflect on the highlights of the week.', 6),
('Tried a new hobby today, and it’s been a lot of fun. Exploring new interests and skills can be so enriching and fulfilling. I’m excited to continue with this new hobby and see how it evolves over time.', 6),
('Visited a beautiful garden and spent some time appreciating the blooms and greenery. Nature has a wonderful way of providing peace and tranquility. It was a refreshing escape from the hustle and bustle of daily life.', 6),
('Feeling optimistic about the upcoming changes and opportunities. Embracing new challenges with an open heart and a positive mindset. It’s exciting to think about what the future holds and the possibilities it brings.', 6);

-- Tweets for user with ID 7
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Had a fantastic day out with friends. The conversations were lively, and the laughter was endless. It’s wonderful to spend quality time with people who lift your spirits and share in the joys of life.', 7),
('Working on a creative project that’s been a passion of mine for a while. It’s thrilling to see it take shape and come to life. Can’t wait to share the final results with you and get your feedback!', 7),
('Just finished a great book that I couldn’t put down. It’s amazing how a well-written story can captivate and inspire you. Looking forward to discussing it with fellow readers and diving into the next book on my list.', 7),
('Had a relaxing day at home, catching up on rest and enjoying some downtime. It’s amazing how taking a break can rejuvenate you and give you a fresh perspective on things. Ready to tackle new challenges with renewed energy.', 7),
('Enjoyed a scenic drive through the countryside today. The views were absolutely stunning, and it was a great way to disconnect and unwind. Sometimes, a change of scenery can do wonders for your mood and mindset.', 7),
('Started a new fitness routine, and I’m already feeling the benefits. Setting small goals and achieving them is so motivating. What are your favorite exercises or routines that keep you feeling fit and strong?', 7),
('Visited a local farmer’s market and picked up some fresh produce. Supporting local vendors and cooking with high-quality ingredients is always a pleasure. Excited to try out some new recipes with my market finds!', 7),
('Spent the day volunteering for a cause I care about. It’s fulfilling to give back to the community and make a positive impact. Volunteering is such a rewarding way to spend your time and connect with others.', 7),
('Had a wonderful evening cooking dinner from scratch. There’s something so satisfying about preparing a meal with love and care. The result was delicious, and I’m already looking forward to my next culinary adventure.', 7),
('Looking forward to the weekend and planning to take it easy. Sometimes, the best way to recharge is to enjoy some downtime and simple pleasures. What are your plans for relaxing and unwinding this weekend?', 7);

-- Tweets for user with ID 8
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Attended a fantastic workshop today that was both enlightening and inspiring. The presenters shared valuable insights, and I walked away with new strategies and ideas. Excited to apply what I’ve learned and see the results!', 8),
('Just tried out a new recipe, and it was a hit! The flavors came together perfectly, and it was so satisfying to create something delicious from scratch. Cooking is such a creative and rewarding experience.', 8),
('Spent the day hiking and exploring new trails. The natural beauty and serenity of the outdoors were just what I needed to clear my mind and refresh my spirit. Can’t wait to discover more scenic spots!', 8),
('Had a great time at a local festival. The atmosphere was vibrant, with wonderful food, music, and activities. It’s always exciting to participate in community events and enjoy the lively energy of the crowd.', 8),
('Enjoying a cozy evening at home with a good book and some soft music. It’s the perfect way to relax and unwind after a busy day. Sometimes, the simple pleasures of life are the most fulfilling.', 8),
('Feeling excited about a new project I’m working on. The initial stages are always the most thrilling, and I’m eager to see how it develops. I’ll be sharing updates as I progress, and I hope you’re as excited as I am!', 8),
('Had a productive day working on creative endeavors. It’s amazing how engaging with a project you’re passionate about can lead to new ideas and breakthroughs. Looking forward to seeing how these concepts evolve!', 8),
('Visited a new art exhibit and was deeply impressed by the creativity and talent on display. Art has such a powerful way of connecting with our emotions and inspiring us. I’m grateful for the opportunity to experience such beauty.', 8),
('Relaxed at the beach today and enjoyed the soothing sound of the waves. The sunshine and fresh sea air were so rejuvenating. It’s moments like these that make you appreciate the natural world and its calming effects.', 8),
('Spending quality time with family this weekend. It’s wonderful to share experiences, create memories, and enjoy each other’s company. Family moments are precious and always worth cherishing.', 8);

-- Tweets for user with ID 9
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Had a relaxing day at the park today. Sometimes, all you need is a little fresh air and nature to reset your mind and recharge. The tranquility of the park was the perfect escape from the hustle and bustle of daily life.', 9),
('Just attended a fascinating seminar on the future of technology. It was incredible to learn about emerging trends and innovations that are shaping the world. Feeling inspired and eager to apply some of these insights to my own work!', 9),
('Trying out a new hobby and loving every minute of it. It’s amazing how picking up new interests can bring so much joy and fulfillment. Looking forward to exploring this new passion further and seeing where it takes me!', 9),
('Enjoying a quiet evening at home. It’s the perfect way to unwind after a busy week. Sometimes, the best moments are spent in the comfort of your own space, reflecting on the week and preparing for the days ahead.', 9),
('Visited a local market today and picked up some fantastic ingredients for a new recipe. I’m excited to try out this dish and see how it turns out. Cooking with fresh, local produce always makes a difference!', 9),
('Had a wonderful time catching up with old friends today. It’s amazing how good conversations and shared memories can lift your spirits. Cherishing these moments of connection and camaraderie.', 9),
('Feeling optimistic about the upcoming changes in my life. Embracing new opportunities with an open heart and a positive outlook. Change can be challenging, but it also brings growth and exciting possibilities!', 9),
('Spent the afternoon working on a creative project. The process was invigorating, and I can’t wait to share the results with you all. Creativity is such a powerful way to express yourself and connect with others.', 9);

-- Tweets for user with ID 10
INSERT INTO TWEET (MESSAGE, USER_ID) VALUES
('Had a productive day working on a new initiative. It’s thrilling to see ideas come to life and make tangible progress. The challenges are worth it when you’re passionate about the work. Excited to keep pushing forward and achieving great things!', 10),
('Just finished reading an inspiring book on personal development. The insights and strategies shared were eye-opening and motivational. Feeling ready to take on new challenges and apply these concepts to my own journey of growth!', 10),
('Enjoyed a fun day out exploring new places. It’s amazing how a change of scenery can refresh your perspective and energize you. Looking forward to more adventures and discovering hidden gems in the city!', 10),
('Had a relaxing evening with a cup of tea and some soothing music. It’s the perfect way to wind down after a busy day and reflect on the positives. Taking time for yourself is so important for maintaining balance and well-being.', 10),
('Spent the day working on some creative projects that I’m truly passionate about. The process has been fulfilling, and I’m eager to see the final results. Creativity has a wonderful way of bringing joy and satisfaction!', 10),
('Tried out a new restaurant for dinner tonight. The food was exceptional, and the experience was delightful. Discovering new culinary spots is always an exciting adventure. I’ll definitely be coming back for more!', 10),
('Had a great workout session this morning. The endorphins are flowing, and I’m feeling fantastic. Exercise is such a great way to boost your mood and energy levels. What are your favorite ways to stay active?', 10),
('Visited a local art gallery and was impressed by the creativity and talent on display. The exhibits were diverse and thought-provoking. It’s always inspiring to experience the work of talented artists and see their unique perspectives.', 10),
('Relaxed at the beach this weekend and enjoyed the calming sound of the waves and the warmth of the sun. It was a much-needed escape from the daily routine and a great way to recharge. Feeling rejuvenated and ready for the week ahead!', 10),
('Caught up on some much-needed rest and relaxation today. It’s amazing how taking a break can help you feel refreshed and re-energized. Ready to take on the new week with a positive mindset and renewed energy!', 10);

SELECT * FROM TWEET;


-- mentions table
CREATE TABLE MENTION(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	TWEET_ID INT NOT NULL,
	USERNAME VARCHAR(15) NOT NULL
);
-- Mentions for tweets (tweet_id 1 to 100)

-- Generating mentions
-- For tweets 1 to 10
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(1, '@bobsmith'),
(1, '@carold'),
(2, '@davidb'),
(2, '@gracelee'),
(3, '@frankw'),
(3, '@henryh'),
(4, '@isabellac'),
(4, '@jackr'),
(5, '@alicej'),
(5, '@bobsmith'),
(6, '@carold'),
(6, '@davidb'),
(7, '@evam'),
(7, '@frankw'),
(8, '@gracelee'),
(8, '@henryh'),
(9, '@isabellac'),
(9, '@jackr'),
(10, '@alicej'),
(10, '@bobsmith');

-- For tweets 11 to 20
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(11, '@carold'),
(11, '@davidb'),
(12, '@gracelee'),
(12, '@evam'),
(13, '@frankw'),
(13, '@isabellac'),
(14, '@jackr'),
(14, '@alicej'),
(15, '@bobsmith'),
(15, '@carold'),
(16, '@davidb'),
(16, '@gracelee'),
(17, '@frankw'),
(17, '@henryh'),
(18, '@isabellac'),
(18, '@jackr'),
(19, '@alicej'),
(19, '@bobsmith'),
(20, '@carold'),
(20, '@davidb');

-- For tweets 21 to 30
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(21, '@gracelee'),
(21, '@frankw'),
(22, '@henryh'),
(22, '@isabellac'),
(23, '@jackr'),
(23, '@alicej'),
(24, '@bobsmith'),
(24, '@carold'),
(25, '@davidb'),
(25, '@gracelee'),
(26, '@evam'),
(26, '@frankw'),
(27, '@isabellac'),
(27, '@jackr'),
(28, '@alicej'),
(28, '@bobsmith'),
(29, '@carold'),
(29, '@davidb'),
(30, '@gracelee'),
(30, '@evam');

-- For tweets 31 to 40
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(31, '@frankw'),
(31, '@isabellac'),
(32, '@jackr'),
(32, '@alicej'),
(33, '@bobsmith'),
(33, '@carold'),
(34, '@davidb'),
(34, '@gracelee'),
(35, '@evam'),
(35, '@henryh'),
(36, '@isabellac'),
(36, '@jackr'),
(37, '@alicej'),
(37, '@bobsmith'),
(38, '@carold'),
(38, '@davidb'),
(39, '@gracelee'),
(39, '@evam'),
(40, '@frankw'),
(40, '@henryh');

-- For tweets 41 to 50
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(41, '@isabellac'),
(41, '@jackr'),
(42, '@alicej'),
(42, '@bobsmith'),
(43, '@carold'),
(43, '@davidb'),
(44, '@gracelee'),
(44, '@evam'),
(45, '@frankw'),
(45, '@henryh'),
(46, '@isabellac'),
(46, '@jackr'),
(47, '@alicej'),
(47, '@bobsmith'),
(48, '@carold'),
(48, '@davidb'),
(49, '@gracelee'),
(49, '@evam'),
(50, '@frankw'),
(50, '@henryh');

-- For tweets 51 to 60
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(51, '@isabellac'),
(51, '@jackr'),
(52, '@alicej'),
(52, '@bobsmith'),
(53, '@carold'),
(53, '@davidb'),
(54, '@gracelee'),
(54, '@evam'),
(55, '@frankw'),
(55, '@henryh'),
(56, '@isabellac'),
(56, '@jackr'),
(57, '@alicej'),
(57, '@bobsmith'),
(58, '@carold'),
(58, '@davidb'),
(59, '@gracelee'),
(59, '@evam'),
(60, '@frankw'),
(60, '@henryh');

-- For tweets 61 to 70
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(61, '@isabellac'),
(61, '@jackr'),
(62, '@alicej'),
(62, '@bobsmith'),
(63, '@carold'),
(63, '@davidb'),
(64, '@gracelee'),
(64, '@evam'),
(65, '@frankw'),
(65, '@henryh'),
(66, '@isabellac'),
(66, '@jackr'),
(67, '@alicej'),
(67, '@bobsmith'),
(68, '@carold'),
(68, '@davidb'),
(69, '@gracelee'),
(69, '@evam'),
(70, '@frankw'),
(70, '@henryh');

-- For tweets 71 to 80
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(71, '@isabellac'),
(71, '@jackr'),
(72, '@alicej'),
(72, '@bobsmith'),
(73, '@carold'),
(73, '@davidb'),
(74, '@gracelee'),
(74, '@evam'),
(75, '@frankw'),
(75, '@henryh'),
(76, '@isabellac'),
(76, '@jackr'),
(77, '@alicej'),
(77, '@bobsmith'),
(78, '@carold'),
(78, '@davidb'),
(79, '@gracelee'),
(79, '@evam'),
(80, '@frankw'),
(80, '@henryh');

-- For tweets 81 to 90
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(81, '@isabellac'),
(81, '@jackr'),
(82, '@alicej'),
(82, '@bobsmith'),
(83, '@carold'),
(83, '@davidb'),
(84, '@gracelee'),
(84, '@evam'),
(85, '@frankw'),
(85, '@henryh'),
(86, '@isabellac'),
(86, '@jackr'),
(87, '@alicej'),
(87, '@bobsmith'),
(88, '@carold'),
(88, '@davidb'),
(89, '@gracelee'),
(89, '@evam'),
(90, '@frankw'),
(90, '@henryh');

-- For tweets 91 to 100
INSERT INTO MENTION (TWEET_ID, USERNAME) VALUES
(91, '@isabellac'),
(91, '@jackr'),
(92, '@alicej'),
(92, '@bobsmith'),
(93, '@carold'),
(93, '@davidb'),
(94, '@gracelee'),
(94, '@evam'),
(95, '@frankw'),
(95, '@henryh'),
(96, '@isabellac'),
(96, '@jackr'),
(97, '@alicej'),
(97, '@bobsmith'),
(98, '@carold'),
(98, '@davidb'),
(99, '@gracelee'),
(99, '@evam'),
(100, '@frankw'),
(100, '@henryh');


SELECT * FROM MENTION;


-- urls table
CREATE TABLE LINK(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	TWEET_ID INT NOT NULL,
	URL VARCHAR(50) NOT NULL
);
-- Insert links for tweets with IDs 1 to 50

-- For tweets 1 to 10
INSERT INTO LINK (TWEET_ID, URL) VALUES
(1, 'http://example.com/page1'),
(1, 'https://example.org/home'),
(2, 'http://example.com/page2'),
(2, 'https://example.org/about'),
(3, 'http://example.com/page3'),
(3, 'https://example.org/contact'),
(4, 'http://example.com/page4'),
(4, 'https://example.org/services'),
(5, 'http://example.com/page5'),
(5, 'https://example.org/products'),
(6, 'http://example.com/page6'),
(6, 'https://example.org/blog'),
(7, 'http://example.com/page7'),
(7, 'https://example.org/portfolio'),
(8, 'http://example.com/page8'),
(8, 'https://example.org/testimonials'),
(9, 'http://example.com/page9'),
(9, 'https://example.org/faqs'),
(10, 'http://example.com/page10'),
(10, 'https://example.org/support');

-- For tweets 11 to 20
INSERT INTO LINK (TWEET_ID, URL) VALUES
(11, 'http://example.com/page11'),
(11, 'https://example.org/news'),
(12, 'http://example.com/page12'),
(12, 'https://example.org/events'),
(13, 'http://example.com/page13'),
(13, 'https://example.org/careers'),
(14, 'http://example.com/page14'),
(14, 'https://example.org/terms'),
(15, 'http://example.com/page15'),
(15, 'https://example.org/privacy'),
(16, 'http://example.com/page16'),
(16, 'https://example.org/updates'),
(17, 'http://example.com/page17'),
(17, 'https://example.org/partners'),
(18, 'http://example.com/page18'),
(18, 'https://example.org/success-stories'),
(19, 'http://example.com/page19'),
(19, 'https://example.org/resources'),
(20, 'http://example.com/page20'),
(20, 'https://example.org/feedback');

-- For tweets 21 to 30
INSERT INTO LINK (TWEET_ID, URL) VALUES
(21, 'http://example.com/page21'),
(21, 'https://example.org/community'),
(22, 'http://example.com/page22'),
(22, 'https://example.org/initiatives'),
(23, 'http://example.com/page23'),
(23, 'https://example.org/our-team'),
(24, 'http://example.com/page24'),
(24, 'https://example.org/awards'),
(25, 'http://example.com/page25'),
(25, 'https://example.org/donate'),
(26, 'http://example.com/page26'),
(26, 'https://example.org/policies'),
(27, 'http://example.com/page27'),
(27, 'https://example.org/investors'),
(28, 'http://example.com/page28'),
(28, 'https://example.org/milestones'),
(29, 'http://example.com/page29'),
(29, 'https://example.org/strategies'),
(30, 'http://example.com/page30'),
(30, 'https://example.org/overview');

-- For tweets 31 to 40
INSERT INTO LINK (TWEET_ID, URL) VALUES
(31, 'http://example.com/page31'),
(31, 'https://example.org/impact'),
(32, 'http://example.com/page32'),
(32, 'https://example.org/innovation'),
(33, 'http://example.com/page33'),
(33, 'https://example.org/blog'),
(34, 'http://example.com/page34'),
(34, 'https://example.org/feedback'),
(35, 'http://example.com/page35'),
(35, 'https://example.org/awards'),
(36, 'http://example.com/page36'),
(36, 'https://example.org/insights'),
(37, 'http://example.com/page37'),
(37, 'https://example.org/collaborations'),
(38, 'http://example.com/page38'),
(38, 'https://example.org/resources'),
(39, 'http://example.com/page39'),
(39, 'https://example.org/success'),
(40, 'http://example.com/page40'),
(40, 'https://example.org/solutions');

-- For tweets 41 to 50
INSERT INTO LINK (TWEET_ID, URL) VALUES
(41, 'http://example.com/page41'),
(41, 'https://example.org/careers'),
(42, 'http://example.com/page42'),
(42, 'https://example.org/milestones'),
(43, 'http://example.com/page43'),
(43, 'https://example.org/announcements'),
(44, 'http://example.com/page44'),
(44, 'https://example.org/our-story'),
(45, 'http://example.com/page45'),
(45, 'https://example.org/impact'),
(46, 'http://example.com/page46'),
(46, 'https://example.org/media'),
(47, 'http://example.com/page47'),
(47, 'https://example.org/join-us'),
(48, 'http://example.com/page48'),
(48, 'https://example.org/achievements'),
(49, 'http://example.com/page49'),
(49, 'https://example.org/latest'),
(50, 'http://example.com/page50'),
(50, 'https://example.org/strategies');


SELECT * FROM LINK;


-- hashtags table
CREATE TABLE HASHTAG(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	TWEET_ID INT NOT NULL,
	TAG VARCHAR(50) NOT NULL
);
-- Insert hashtags for tweets with IDs 1 to 50

-- For tweets 1 to 10
INSERT INTO HASHTAG (TWEET_ID, TAG) VALUES
(1, '#Welcome'),
(1, '#NewBeginnings'),
(2, '#Travel'),
(2, '#Adventure'),
(3, '#Foodie'),
(3, '#Delicious'),
(4, '#Motivation'),
(4, '#Success'),
(5, '#Tech'),
(5, '#Innovation'),
(6, '#Nature'),
(6, '#Photography'),
(7, '#Fitness'),
(7, '#Health'),
(8, '#Music'),
(8, '#LiveMusic'),
(9, '#Books'),
(9, '#Reading'),
(10, '#Weekend'),
(10, '#Relaxation');

-- For tweets 11 to 20
INSERT INTO HASHTAG (TWEET_ID, TAG) VALUES
(11, '#Sports'),
(11, '#FitnessGoals'),
(12, '#Movies'),
(12, '#Cinema'),
(13, '#Art'),
(13, '#Creativity'),
(14, '#Fashion'),
(14, '#Style'),
(15, '#Gaming'),
(15, '#Esports'),
(16, '#Science'),
(16, '#Discovery'),
(17, '#Education'),
(17, '#Learning'),
(18, '#Environment'),
(18, '#Sustainability'),
(19, '#Culture'),
(19, '#Tradition'),
(20, '#Family'),
(20, '#Love');

-- For tweets 21 to 30
INSERT INTO HASHTAG (TWEET_ID, TAG) VALUES
(21, '#Lifestyle'),
(21, '#DailyRoutine'),
(22, '#DIY'),
(22, '#Crafts'),
(23, '#Pets'),
(23, '#Animals'),
(24, '#Quotes'),
(24, '#Inspiration'),
(25, '#Events'),
(25, '#Happenings'),
(26, '#HealthTips'),
(26, '#Wellness'),
(27, '#Technology'),
(27, '#Future'),
(28, '#TravelTips'),
(28, '#Explore'),
(29, '#Food'),
(29, '#Recipe'),
(30, '#Hobbies'),
(30, '#Fun');

-- For tweets 31 to 40
INSERT INTO HASHTAG (TWEET_ID, TAG) VALUES
(31, '#FitnessJourney'),
(31, '#Goals'),
(32, '#MusicLovers'),
(32, '#Concert'),
(33, '#Bookshelf'),
(33, '#Bookworm'),
(34, '#Mindfulness'),
(34, '#Meditation'),
(35, '#Entrepreneur'),
(35, '#StartUp'),
(36, '#Wellbeing'),
(36, '#SelfCare'),
(37, '#TravelDiaries'),
(37, '#Wanderlust'),
(38, '#ArtWork'),
(38, '#Artist'),
(39, '#FoodieLife'),
(39, '#Gourmet'),
(40, '#Holiday'),
(40, '#Festive');

-- For tweets 41 to 50
INSERT INTO HASHTAG (TWEET_ID, TAG) VALUES
(41, '#FitnessGoals'),
(41, '#HealthierYou'),
(42, '#FashionTrends'),
(42, '#StyleInspo'),
(43, '#GamingCommunity'),
(43, '#GameOn'),
(44, '#ScienceFacts'),
(44, '#TechTrends'),
(45, '#BookRecommendations'),
(45, '#MustReads'),
(46, '#EnvironmentallyFriendly'),
(46, '#GreenLiving'),
(47, '#InspirationalQuotes'),
(47, '#Wisdom'),
(48, '#TravelAdventures'),
(48, '#TravelPhotography'),
(49, '#PetLove'),
(49, '#AnimalFriends'),
(50, '#CreativeIdeas'),
(50, '#ArtisticExpression');



SELECT * FROM HASHTAG;