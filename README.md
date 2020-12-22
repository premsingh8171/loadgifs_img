# Load Giphy gifs

<img src="https://github.com/Giphy/GiphyAPI/blob/master/api_giphy_header.gif" />

The **Giphy Core SDK** is a wrapper around [Giphy API](https://github.com/Giphy/GiphyAPI).

[![Build Status](https://travis-ci.com/Giphy/giphy-android-sdk-core.svg?token=3hcMqsQ6jx6dUF9GvWxR&branch=master)](https://travis-ci.com/Giphy/giphy-android-sdk-core)

[Giphy](https://www.giphy.com) is the best way to search, share, and discover GIFs on the Internet. Similar to the way other search engines work, the majority of our content comes from indexing based on the best and most popular GIFs and search terms across the web. We organize all those GIFs so you can find the good content easier and share it out through your social channels. We also feature some of our favorite GIF artists and work with brands to create and promote their original GIF content.

## Using GIPHY API

Step 1. Visit Giphy Developers webside link:
https://developers.giphy.com/

Step 2. Register on giphy developers

Step 2. Create application and after creation copy ApiKey (ApiKey=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV)

Step 3. Mention your apiKay and data limit in following url https://api.giphy.com/v1/gifs/trending?api_key=ApiKey&limit=25

Step 3.Check your api in https://developers.giphy.com/explorer

<img src="https://github.com/premsingh8171/loadgifs_img/blob/main/app/src/main/res/drawable/gippy_explor.png" />

## Responce

```
{
  "data": [
    {
      "type": "gif",
      "id": "h8pOG74kcNuYWm2hhS",
      "url": "https://giphy.com/gifs/moodman-christmas-on-my-way-h8pOG74kcNuYWm2hhS",
      "slug": "moodman-christmas-on-my-way-h8pOG74kcNuYWm2hhS",
      "bitly_gif_url": "https://gph.is/g/aKdMP2o",
      "bitly_url": "https://gph.is/g/aKdMP2o",
      "embed_url": "https://giphy.com/embed/h8pOG74kcNuYWm2hhS",
      "username": "",
      "source": "",
      "title": "On My Way Christmas GIF by MOODMAN",
      "rating": "g",
      "content_url": "",
      "source_tld": "",
      "source_post_url": "",
      "is_sticker": 0,
      "import_datetime": "2020-12-16 07:55:55",
      "trending_datetime": "2020-12-22 04:45:13",
      "images": {
        "original": {
          "height": "480",
          "width": "480",
          "size": "3457413",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy.gif",
          "mp4_size": "1001354",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy.mp4",
          "webp_size": "922056",
          "webp": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy.webp",
          "frames": "46",
          "hash": "a6b125902c81e2b2df4c4715faa44240"
        },
        "downsized": {
          "height": "480",
          "width": "480",
          "size": "1962652",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy-downsized.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy-downsized.gif"
        },
        "downsized_large": {
          "height": "480",
          "width": "480",
          "size": "3457413",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy.gif"
        },
        "downsized_medium": {
          "height": "480",
          "width": "480",
          "size": "3457413",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy.gif"
        },
        "downsized_small": {
          "height": "214",
          "width": "214",
          "mp4_size": "108679",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy-downsized-small.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy-downsized-small.mp4"
        },
        "downsized_still": {
          "height": "480",
          "width": "480",
          "size": "33516",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy-downsized_s.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy-downsized_s.gif"
        },
        "fixed_height": {
          "height": "200",
          "width": "200",
          "size": "573959",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200.gif",
          "mp4_size": "161167",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200.mp4",
          "webp_size": "236356",
          "webp": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200.webp"
        },
        "fixed_height_downsampled": {
          "height": "200",
          "width": "200",
          "size": "94340",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200_d.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200_d.gif",
          "webp_size": "56132",
          "webp": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200_d.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200_d.webp"
        },
        "fixed_height_small": {
          "height": "100",
          "width": "100",
          "size": "203591",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100.gif",
          "mp4_size": "66651",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100.mp4",
          "webp_size": "106848",
          "webp": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100.webp"
        },
        "fixed_height_small_still": {
          "height": "100",
          "width": "100",
          "size": "4525",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100_s.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100_s.gif"
        },
        "fixed_height_still": {
          "height": "200",
          "width": "200",
          "size": "10923",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200_s.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200_s.gif"
        },
        "fixed_width": {
          "height": "200",
          "width": "200",
          "size": "573959",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200w.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200w.gif",
          "mp4_size": "161167",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200w.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200w.mp4",
          "webp_size": "236356",
          "webp": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200w.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200w.webp"
        },
        "fixed_width_downsampled": {
          "height": "200",
          "width": "200",
          "size": "94340",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200w_d.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200w_d.gif",
          "webp_size": "56132",
          "webp": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200w_d.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200w_d.webp"
        },
        "fixed_width_small": {
          "height": "100",
          "width": "100",
          "size": "203591",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100w.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100w.gif",
          "mp4_size": "48101",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100w.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100w.mp4",
          "webp_size": "106848",
          "webp": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100w.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100w.webp"
        },
        "fixed_width_small_still": {
          "height": "100",
          "width": "100",
          "size": "4525",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/100w_s.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=100w_s.gif"
        },
        "fixed_width_still": {
          "height": "200",
          "width": "200",
          "size": "10923",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/200w_s.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=200w_s.gif"
        },
        "looping": {
          "mp4_size": "4536793",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy-loop.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy-loop.mp4"
        },
        "original_still": {
          "height": "480",
          "width": "480",
          "size": "59978",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy_s.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy_s.gif"
        },
        "original_mp4": {
          "height": "480",
          "width": "480",
          "mp4_size": "1001354",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy.mp4"
        },
        "preview": {
          "height": "212",
          "width": "212",
          "mp4_size": "41151",
          "mp4": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy-preview.mp4?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy-preview.mp4"
        },
        "preview_gif": {
          "height": "76",
          "width": "76",
          "size": "47739",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy-preview.gif?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy-preview.gif"
        },
        "preview_webp": {
          "height": "158",
          "width": "158",
          "size": "33860",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/giphy-preview.webp?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=giphy-preview.webp"
        },
        "480w_still": {
          "height": "480",
          "width": "480",
          "size": "3457413",
          "url": "https://media3.giphy.com/media/h8pOG74kcNuYWm2hhS/480w_s.jpg?cid=8a0ebbb0qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&rid=480w_s.jpg"
        }
      },
      "analytics_response_payload": "e=Z2lmX2lkPWg4cE9HNzRrY051WVdtMmhoUyZldmVudF90eXBlPUdJRl9UUkVORElORyZjaWQ9OGEwZWJiYjBxcG85Mmg4Z28wZG5naG5pODIxbndsMHlrMmVtMXVyazJ3M2ExbThv",
      "analytics": {
        "onload": {
          "url": "https://giphy-analytics.giphy.com/simple_analytics?response_id=qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&event_type=GIF_TRENDING&gif_id=h8pOG74kcNuYWm2hhS&action_type=SEEN"
        },
        "onclick": {
          "url": "https://giphy-analytics.giphy.com/simple_analytics?response_id=qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&event_type=GIF_TRENDING&gif_id=h8pOG74kcNuYWm2hhS&action_type=CLICK"
        },
        "onsent": {
          "url": "https://giphy-analytics.giphy.com/simple_analytics?response_id=qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o&event_type=GIF_TRENDING&gif_id=h8pOG74kcNuYWm2hhS&action_type=SENT"
        }
      }
    }
  ],
  "pagination": {
    "total_count": 107785,
    "count": 25,
    "offset": 0
  },
  "meta": {
    "status": 200,
    "msg": "OK",
    "response_id": "qpo92h8go0dnghni821nwl0yk2em1urk2w3a1m8o"
  }
}
```
## Result of following responce

<img src="https://raw.githubusercontent.com/premsingh8171/loadgifs_img/main/app/src/main/res/drawable/gifs.gif" width="300" height="550" /> <img src="https://raw.githubusercontent.com/premsingh8171/loadgifs_img/main/app/src/main/res/drawable/afterclick.jpeg" width="300" height="550" /> <br><img src="https://github.com/premsingh8171/loadgifs_img/blob/main/app/src/main/res/drawable/update_gif.gif" width="300" height="550" /> <img src="https://github.com/premsingh8171/loadgifs_img/blob/main/app/src/main/res/drawable/updategif2.gif" width="300" height="550" />



<h2>Created by:</h2>
<p>Er.Prem singh daksha  premsingh8171@gmail.com</p>
<p><a href="https://www.linkedin.com/in/prem-singh-daksha-82az/"> <img src="https://github.com/anitaa1990/DeviceInfo-Sample/blob/master/media/linkedin-icon.png" alt="Linkedin" style="max-width:100%;"> </a></p>
